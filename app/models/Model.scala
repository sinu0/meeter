package models

import play.api.db.slick.Config.driver.simple._
import play.api.mvc._
import scala.slick.lifted.TableQuery
import play.api.Play.current

/**
 * Created by mar on 18.11.14.
 */
object Model {

  val _user = TableQuery[UserDataTable]

  def findUserByName(name: String): Option[UserData] = {
    play.api.db.slick.DB.withSession { implicit session =>
      _user.filter(_.name === name).list().headOption
    }
  }

}
