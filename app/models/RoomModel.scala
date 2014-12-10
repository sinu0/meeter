package models

import java.sql.Date

import play.api.db.slick.Config.driver.simple._

case class UserData(userId: Long, name: String, password: String)

case class RoomT(roomId: Long, roomName: String, creatorId: Long, perm: String, labelType: String, dateFrom: Date, dateTo: Date, maxValue: Int, Labels: String)

case class CreateRoom(roomName: String, perm: String, labelType: String, dateFrom: Date, dateTo: Date,maxValue:Int, Labels:String)

case class Login(login: String, password: String)

case class Register(email: String, confirmEmail: String, password: String, confirmPassword: String)

case class SurveyRoom(id: Long, roomId: Long, userId: Long, data: String)

case class UserUpdate(name: String, roomId: Long, data: String)

case class RoomData(survey: SurveyRoom, user: UserData)

case class Message(email: String, message: String)

/* Table mapping
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

  def * = (id, roomId, userId, data) <>(SurveyRoom.tupled, SurveyRoom.unapply _)

  def roomFk = foreignKey("roomFk", roomId, roomTable)(_.id)

  def userFk = foreignKey("userFk", userId, userTable)(_.id)
}

class RoomTable(tag: Tag) extends Table[RoomT](tag, "ROOM") {

  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def roomName = column[String]("roomName", O.NotNull)

  def creatorId = column[Long]("creatorId", O.Nullable)

  def perm = column[String]("permission", O.NotNull)

  def labelType = column[String]("dataType", O.NotNull)

  // YEAR,MONTH,DAY,HOUR
  def dateFrom = column[Date]("dateFrom", O.NotNull)

  def dateTo = column[Date]("dateTo", O.NotNull)

  def labels = column[String]("labels", O.NotNull)

  def maxValue = column[Int]("maxValue", O.NotNull)

  def * = (id, roomName, creatorId, perm, labelType, dateFrom, dateTo, maxValue, labels) <>(RoomT.tupled, RoomT.unapply _)

}





