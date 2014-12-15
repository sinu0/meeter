package controllers

import models._
import org.apache.commons.codec.DecoderException
import org.h2.jdbc.JdbcSQLException
import play.api.Play.current
import play.api._
import play.api.data.Forms._
import play.api.data._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.libs._
import play.api.libs.json.Json
import play.api.libs.json.Json._
import play.api.mvc._
import com.feth.play.module.mail.Mailer;
import com.feth.play.module.mail.Mailer.Mail.Attachment;
import com.feth.play.module.mail.Mailer.Mail.Body;


object Application extends Controller with Secured {

  //create an instance of the table
  val user = TableQuery[UserDataTable]
  val roomT = TableQuery[RoomTable]
  val survey = TableQuery[SurveyTable]
  //see a way to architect your app in the computers-database-slick sample

  //JSON read/write macro

  implicit val userFormat = Json.format[UserData]
  implicit val roomFormat = Json.format[CreateRoom]

  def dashboard = withUser { us => implicit request =>
    val prem = new models.Permission().values.toList.map(_.toString)

    val userRooms: List[RoomT] = roomT.filter(_.creatorId === us.userId).list

    Ok(views.html.index(us, prem, userRooms))
  }


  val createRoomForm = Form(
    mapping(
      "name" -> text,
      "message" -> text,
      "perm" -> text,
      "labelType" -> text,
      "dateFrom" -> sqlDate,
      "dateTo" -> sqlDate,
      "maxValue" -> number(0, 10),
      "labels" -> text,
      "users" ->list(text),
      "endDay" -> sqlDate("yyyy-MM-dd'T'hh:mm")
    )(CreateRoom.apply)(CreateRoom.unapply) verifying("Invalid form", form => form match {
      case form => Logger.logger.debug(form.toString); !form.roomName.isEmpty || !form.perm.isEmpty || !form.labelType.isEmpty || form.dateTo.before(form.dateFrom) || form.Labels.split(',').length < 3
    })
  )

  val loginForm = Form(
    mapping(
      "email" -> email,
      "pass" -> text
    )(Login.apply)(Login.unapply) verifying("Username or Password is incorrect", form => form match {
      case login => Validation.validateUser(login)
    })
  )
  val registerForm = Form(
    mapping(
      "email" -> email,
      "emailconf" -> email,
      "pass" -> text,
      "passconf" -> text
    )(Register.apply)(Register.unapply) verifying("Wrong email or password", form => form match {
      case data => data.email == data.confirmEmail && data.password == data.confirmPassword
    })
  )
  val sendMessage = Form(
    mapping(
      "email" -> email,
      "message" -> text
    )(Message.apply)(Message.unapply) verifying("Empty message box or email", form => form match {
      case data => !data.email.isEmpty && !data.email.isEmpty
    })
  )

  def register = Action { implicit request =>
    if (request.session.get(Security.username).isDefined) {
      Redirect(routes.Application.dashboard)
    } else
      Ok(views.html.register(registerForm))

  }

  def registerUser = DBAction {
    implicit rs =>
      registerForm.bindFromRequest().fold(
        error => BadRequest(views.html.register(error)),
        u => {

          try {
            user.insert(UserData(0, u.email, Crypto.encryptAES(u.password)))
            Mailer.getDefaultMailer().sendMail("Hello in Meeter " + u.email,"You are now register in Meeter!",u.email);
            val uri = rs.request.session.get("url")
            if (uri.isDefined) {
              rs.request.session.-("url")
              Redirect(uri.get).withSession(Security.username -> u.email)
            } else
              Redirect(routes.Application.dashboard).withSession(Security.username -> u.email)
          } catch {
            case e: JdbcSQLException => BadRequest(views.html.register(registerForm.withGlobalError("Given email allready exists: " + u.email)))
            case e: Throwable =>
              Logger.logger.error("Error while register new user", e)
              BadRequest(views.html.register(registerForm.withGlobalError("Unexpected error")))
          }

        }
      )
  }

  def login = Action { implicit request =>
    if (request.session.get(Security.username).isDefined) {
      Redirect(routes.Application.dashboard)
    } else
      Ok(views.html.login(loginForm))
  }

  def auth = Action { implicit request =>
    if (request.session.get(Security.username).isDefined) {
      Redirect(routes.Application.dashboard)
    } else
      loginForm.bindFromRequest().fold(
        error => BadRequest(views.html.login(error)),
        user => {
          val uri = request.session.get("url")
          if (uri.isDefined) {
            request.session.-("url")
            Redirect(uri.get).withSession(Security.username -> user.login)
          }
          else
            Redirect(routes.Application.dashboard).withSession(Security.username -> user.login)
        }
      )
  }

  def logout = Action {
    implicit req =>
      Redirect(routes.Application.dashboard).withNewSession
  }

  def insert = Action { implicit rs =>
    //    val rooms = userFrom.bindFromRequest.get
    //val names = rooms.name
    // Logger.logger.error("test " + names + " " + rooms.data)
    //user.insert(UserData(0,roomId,names,rooms.data))



    Redirect(routes.Application.dashboard)
  }

  def createRoomPage = withUser {
    us => implicit session =>
      val perm = (new Permission).values.toList.map(f => f.toString)
      Ok(views.html.createRoom(us, perm, createRoomForm))
  }

  def createRoom = withUser { us =>
    implicit request =>
      createRoomForm.bindFromRequest().fold(
        error => Ok(views.html.createRoom(us, (new Permission).values.toList.map(f => f.toString), error.withGlobalError("Invalid form " + error.errors.toString))),
        room => {
          try {
            val roomId = (roomT returning roomT.map(_.id)) += RoomT(0, room.roomName,room.message, us.userId, room.perm, room.labelType, room.dateFrom, room.dateTo, room.maxValue, room.Labels, room.endDay)
            
            survey.insert(SurveyRoom(0, roomId, us.userId, "0"))
            Redirect(routes.Application.room(Crypto.encryptAES(roomId.toString)))
          } catch {
            case e: JdbcSQLException => Logger.logger.error("error", e)
              Redirect(routes.Application.dashboard)
          }
        }
      )
  }

  def room(token: String) = Action { implicit request =>
    DB.withSession { implicit session =>
      try {
        val id = Crypto.decryptAES(token).toLong
        val r = roomT.filter(f => f.id === id).list()
        val s = survey.filter(f => f.roomId === id) join user on (_.userId === _.id)
        val userData = s.list.map {
          elem =>
            (elem._1.userId, elem._1.data, elem._2.name)
        }
        val p = new Permission()

        r.headOption match {
          case Some(RoomT(_, name,_, _, perm, _, _, _, _, _, endTime)) => p.withName(perm) match {
            case p.NONPUBLIC =>
              getUserIdFromRequest(request) match {
                case Some(u) =>
                  if (s.filter(_._2.id === u.userId).list().size > 0)
                    Ok(views.html.room(userData, perm,endTime))
                  else
                    Unauthorized(views.html.unauthorized())
                case _ =>
                  Unauthorized(views.html.unauthorized())
              }
            case p.PUBLIC =>
              Ok(views.html.room(userData, perm,endTime))
            case p.WNONPUBLIC =>
              Ok("")
            case p.WPUBLIC =>
              Ok("")
            case somePerm => InternalServerError(views.html.unknownError(somePerm.toString))

          }
          case None => NotFound(views.html.errorPage())
        }

      } catch {
        case e: DecoderException => NotFound(views.html.errorPage())
        case e: Throwable => InternalServerError(views.html.unknownError(e.toString))
      }

    }
  }

  def getUserIdFromRequest(req: Request[AnyContent]): Option[UserData] = {
    req.session.get(Security.username) match {
      case Some(userName: String) => Model.findUserByName(userName) match {
        case Some(user) => Option(user)
        case _ => None
      }
      case _ => None
    }

  }

  def help() = Action {
    implicit request =>
      Ok(views.html.help(sendMessage))
  }

  def editRoom(token: String) = withUser {
    u => implicit rs =>
      Ok(views.html.editSurvey())
  }

  def insertToRoom(id: Long) = DBAction { implicit rs =>
    //    val rooms = userFrom.bindFromRequest.get
    //val names = rooms.name
    // Logger.logger.error("test " + names + " " +rooms.data)
    //user.insert(UserData(0,roomId,names,rooms.data))



    Redirect(routes.Application.dashboard)
  }

  def deleteRoom(id: String) = withJsonUser { us => implicit request =>

    try {
      val i = Crypto.decryptAES(id).toLong
      roomT.filter(f => (f.creatorId === us.userId && f.id === i)).list.size match {
        case 1 =>
          roomT.filter(f => f.id === i).delete match {
            case 1 => Ok(Json.obj("status" -> "OK", "code" -> "200"))
            case 0 => BadRequest(Json.obj("status" -> "400", "message" -> "Room deletion failed"))
            case e => BadRequest(Json.obj("status" -> "400", "message" -> "Unexcepted error "))
          }
        case _ => Unauthorized(Json.obj("status" -> "401", "message" -> "Unexcepted error "))
      }
    } catch {
      case e: Throwable => BadRequest(Json.obj("status" -> "400", "message" -> e.getCause.toString))
    }
  }

  def jsonFindAll = DBAction { implicit rs =>

    Ok(toJson(user.list))
  }

  //  def putJsonData(roomId:String): Action = {
  //
  //  }

  def jsonGet(id: Long) = withAuth { r =>
    implicit rs =>

      val byId = user.where(f => f.id === id).list()
      Ok(toJson(byId))
  }

  def jsonInsertUserData = DBAction(parse.json) { implicit rs =>
    rs.request.body.validate[UserData].map { data =>
      Logger.logger.error(data.toString)
      user.insert(data)
      Ok(toJson(data))
    }.getOrElse(BadRequest("invalid json"))
  }

  def jsonCreateRoom = DBAction(parse.json) {
    implicit rs =>
      rs.request.body.validate[CreateRoom].map { rooms =>
        Ok(toJson(rooms))
      }.getOrElse(BadRequest("Bad json"))
  }

}
