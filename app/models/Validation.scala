package models

import play.api.Logger
import play.api.libs.Crypto

/**
 * Created by mar on 18.11.14.
 */
object Validation {

  def validateUser(login: Login): Boolean = {
    Model.findUserByName(login.login) match {
      case Some(user: UserData) =>
        login.login == user.name && Crypto.encryptAES(login.password) == user.password
      case _ => false
    }

  }

}
