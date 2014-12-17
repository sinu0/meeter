package models

import java.sql.Date

import play.api.db.slick.Config.driver.simple._

import scala.slick.model.ForeignKeyAction

case class UserData(userId: Long, name: String, password: String)

case class RoomT(roomId: Long, roomName: String, message: String, creatorId: Long, perm: String, labelType: String, dateFrom: Date, dateTo: Date, maxValue: Int, Labels: String, endDate: Date)

case class CreateRoom(roomName: String, message: String, perm: String, labelType: String, dateFrom: Date, dateTo: Date, maxValue: Int, values: String, Labels: String, usersEmails: List[String], endDay: Date)

case class Login(login: String, password: String)

case class Register(email: String, confirmEmail: String, password: String, confirmPassword: String)

case class SurveyRoom(id: Long, roomId: Long, userId: Long, data: String, strokeColor: String)

case class UserUpdate(name: String, roomId: Long, data: String)

case class RoomData(survey: SurveyRoom, user: UserData)

case class DataSets(max:Int, labels:Array[String],label: String, fillColor: String, StrokeColor: String, pointColor: String, pointStrokeColor: String, pointHighlightFill: String, pointHighlightStroke: String, data: Array[Int])

case class Message(email: String, message: String)

/* Table mapping test
 */
class UserDataTable(tag: Tag) extends Table[UserData](tag, "USER") {

  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def name = column[String]("name", O.NotNull)

  def password = column[String]("password", O.NotNull)

  def * = (id, name, password) <>(UserData.tupled, UserData.unapply _)

  def uni = index("uniqe", name, unique = true)
}

class SurveyTable(tag: Tag) extends Table[SurveyRoom](tag, "SURVEY") {

  val userTable = TableQuery[UserDataTable]
  val roomTable = TableQuery[RoomTable]

  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def roomId = column[Long]("roomId")

  def userId = column[Long]("userId")

  def data = column[String]("data", O.NotNull)

  def strokeColor = column[String]("color", O.NotNull)

  def * = (id, roomId, userId, data, strokeColor) <>(SurveyRoom.tupled, SurveyRoom.unapply _)

  def roomFk = foreignKey("roomFk", roomId, roomTable)(_.id, onDelete = ForeignKeyAction.Cascade)

  def userFk = foreignKey("userFk", userId, userTable)(_.id, onDelete = ForeignKeyAction.Cascade)
}

class RoomTable(tag: Tag) extends Table[RoomT](tag, "ROOM") {

  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def message = column[String]("message")

  def roomName = column[String]("roomName", O.NotNull)

  def creatorId = column[Long]("creatorId", O.Nullable)

  def perm = column[String]("permission", O.NotNull)

  def labelType = column[String]("dataType", O.NotNull)

  // YEAR,MONTH,DAY,HOUR
  def dateFrom = column[Date]("dateFrom", O.NotNull)

  def dateTo = column[Date]("dateTo", O.NotNull)

  def labels = column[String]("labels", O.NotNull)

  def maxValue = column[Int]("maxValue", O.NotNull)

  def endDate = column[Date]("endDate", O.NotNull)

  def * = (id, message, roomName, creatorId, perm, labelType, dateFrom, dateTo, maxValue, labels, endDate) <>(RoomT.tupled, RoomT.unapply _)

}





