package controllers

import models.{Model, UserData, UserDataTable, Login}
import play.api.db.slick.{DBAction, DBSessionRequest}
import play.api.libs.json.Json
import play.api.mvc._
import play.api.db.slick.Config.driver.simple._
import play.mvc.Results.Redirect
import scala.slick.lifted.{Query, TableQuery}

/**
 * Created by mar on 18.11.14.
 */
trait Secured {


  def username(request: RequestHeader) = request.session.get(Security.username)

  def onUnauthorized(request: RequestHeader) = Results.Redirect(routes.Application.login).withSession("url" -> request.uri)
  def onUnauthorizedJsonCall(request: RequestHeader) = Results.Unauthorized(Json.obj("status" -> "unauthorized operation"))

  //  def withAuth(f: => String => Request[AnyContent] => Result) = {
  //    Security.Authenticated(username, onUnauthorized) { user =>
  //      Action(request => f(user)(request))
  //    }
  //  }
  def withAuth(f: => String => DBSessionRequest[AnyContent] => Result) = {
    Security.Authenticated(username, onUnauthorized) { user =>
      DBAction(request =>

      {
        f(user)(request)
      })
    }
  }
  def withJsonAuth(f: => String => DBSessionRequest[AnyContent] => Result) = {
    Security.Authenticated(username, onUnauthorizedJsonCall) { user =>
      DBAction(request =>

      {
        f(user)(request)
      })
    }
  }

  /**
   * This method shows how you could wrap the withAuth method to also fetch your user
   * You will need to implement UserDAO.findOneByUsername
   */
  def withUser(f: UserData => DBSessionRequest[AnyContent] => Result) = withAuth { username => implicit request =>
    Model.findUserByName(username).map { user =>
      f(user)(request)
    }.getOrElse(onUnauthorized(request))
  }
  def withJsonUser(f: UserData => DBSessionRequest[AnyContent] => Result) = withJsonAuth { username => implicit request =>
    Model.findUserByName(username).map { user =>
      f(user)(request)
    }.getOrElse(onUnauthorizedJsonCall(request))
  }
}