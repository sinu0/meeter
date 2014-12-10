// @SOURCE:/home/mar/play-slick-quickstart/conf/routes
// @HASH:d30413139c2959418884c8b5cb46a5d275486f7b
// @DATE:Wed Dec 03 16:37:13 CET 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:7
private[this] lazy val controllers_Application_dashboard0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_dashboard0_invoker = createInvoker(
controllers.Application.dashboard,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "dashboard", Nil,"GET", """""", Routes.prefix + """"""))
        

// @LINE:8
private[this] lazy val controllers_Application_logout1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_Application_logout1_invoker = createInvoker(
controllers.Application.logout,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:9
private[this] lazy val controllers_Application_login2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Application_login2_invoker = createInvoker(
controllers.Application.login,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Nil,"GET", """""", Routes.prefix + """login"""))
        

// @LINE:10
private[this] lazy val controllers_Application_register3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
private[this] lazy val controllers_Application_register3_invoker = createInvoker(
controllers.Application.register,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "register", Nil,"GET", """""", Routes.prefix + """register"""))
        

// @LINE:11
private[this] lazy val controllers_Application_room4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("room/"),DynamicPart("token", """[^/]+""",true))))
private[this] lazy val controllers_Application_room4_invoker = createInvoker(
controllers.Application.room(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "room", Seq(classOf[String]),"GET", """""", Routes.prefix + """room/$token<[^/]+>"""))
        

// @LINE:12
private[this] lazy val controllers_Application_jsonFindAll5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("json/all"))))
private[this] lazy val controllers_Application_jsonFindAll5_invoker = createInvoker(
controllers.Application.jsonFindAll,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsonFindAll", Nil,"GET", """""", Routes.prefix + """json/all"""))
        

// @LINE:13
private[this] lazy val controllers_Application_jsonGet6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("json/getbyid/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Application_jsonGet6_invoker = createInvoker(
controllers.Application.jsonGet(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsonGet", Seq(classOf[Long]),"GET", """""", Routes.prefix + """json/getbyid/$id<[^/]+>"""))
        

// @LINE:14
private[this] lazy val controllers_Application_editRoom7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit/"),DynamicPart("token", """[^/]+""",true))))
private[this] lazy val controllers_Application_editRoom7_invoker = createInvoker(
controllers.Application.editRoom(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "editRoom", Seq(classOf[String]),"GET", """""", Routes.prefix + """edit/$token<[^/]+>"""))
        

// @LINE:15
private[this] lazy val controllers_Application_createRoomPage8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("createRoom"))))
private[this] lazy val controllers_Application_createRoomPage8_invoker = createInvoker(
controllers.Application.createRoomPage,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "createRoomPage", Nil,"GET", """""", Routes.prefix + """createRoom"""))
        

// @LINE:16
private[this] lazy val controllers_Application_help9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("help"))))
private[this] lazy val controllers_Application_help9_invoker = createInvoker(
controllers.Application.help,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "help", Nil,"GET", """""", Routes.prefix + """help"""))
        

// @LINE:19
private[this] lazy val controllers_Application_insert10_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("insert"))))
private[this] lazy val controllers_Application_insert10_invoker = createInvoker(
controllers.Application.insert,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "insert", Nil,"POST", """ Home page""", Routes.prefix + """insert"""))
        

// @LINE:20
private[this] lazy val controllers_Application_jsonCreateRoom11_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("json/"))))
private[this] lazy val controllers_Application_jsonCreateRoom11_invoker = createInvoker(
controllers.Application.jsonCreateRoom,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsonCreateRoom", Nil,"POST", """""", Routes.prefix + """json/"""))
        

// @LINE:21
private[this] lazy val controllers_Application_createRoom12_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("createRoom"))))
private[this] lazy val controllers_Application_createRoom12_invoker = createInvoker(
controllers.Application.createRoom,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "createRoom", Nil,"POST", """""", Routes.prefix + """createRoom"""))
        

// @LINE:22
private[this] lazy val controllers_Application_auth13_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth"))))
private[this] lazy val controllers_Application_auth13_invoker = createInvoker(
controllers.Application.auth,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "auth", Nil,"POST", """""", Routes.prefix + """auth"""))
        

// @LINE:23
private[this] lazy val controllers_Application_registerUser14_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registerUser"))))
private[this] lazy val controllers_Application_registerUser14_invoker = createInvoker(
controllers.Application.registerUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "registerUser", Nil,"POST", """""", Routes.prefix + """registerUser"""))
        

// @LINE:27
private[this] lazy val controllers_Assets_at15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at15_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """PUT         /json/:id               controllers.Application.
 Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.dashboard"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Application.register"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """room/$token<[^/]+>""","""controllers.Application.room(token:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/all""","""controllers.Application.jsonFindAll"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/getbyid/$id<[^/]+>""","""controllers.Application.jsonGet(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit/$token<[^/]+>""","""controllers.Application.editRoom(token:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """createRoom""","""controllers.Application.createRoomPage"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """help""","""controllers.Application.help"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """insert""","""controllers.Application.insert"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/""","""controllers.Application.jsonCreateRoom"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """createRoom""","""controllers.Application.createRoom"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth""","""controllers.Application.auth"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registerUser""","""controllers.Application.registerUser"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:7
case controllers_Application_dashboard0_route(params) => {
   call { 
        controllers_Application_dashboard0_invoker.call(controllers.Application.dashboard)
   }
}
        

// @LINE:8
case controllers_Application_logout1_route(params) => {
   call { 
        controllers_Application_logout1_invoker.call(controllers.Application.logout)
   }
}
        

// @LINE:9
case controllers_Application_login2_route(params) => {
   call { 
        controllers_Application_login2_invoker.call(controllers.Application.login)
   }
}
        

// @LINE:10
case controllers_Application_register3_route(params) => {
   call { 
        controllers_Application_register3_invoker.call(controllers.Application.register)
   }
}
        

// @LINE:11
case controllers_Application_room4_route(params) => {
   call(params.fromPath[String]("token", None)) { (token) =>
        controllers_Application_room4_invoker.call(controllers.Application.room(token))
   }
}
        

// @LINE:12
case controllers_Application_jsonFindAll5_route(params) => {
   call { 
        controllers_Application_jsonFindAll5_invoker.call(controllers.Application.jsonFindAll)
   }
}
        

// @LINE:13
case controllers_Application_jsonGet6_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_jsonGet6_invoker.call(controllers.Application.jsonGet(id))
   }
}
        

// @LINE:14
case controllers_Application_editRoom7_route(params) => {
   call(params.fromPath[String]("token", None)) { (token) =>
        controllers_Application_editRoom7_invoker.call(controllers.Application.editRoom(token))
   }
}
        

// @LINE:15
case controllers_Application_createRoomPage8_route(params) => {
   call { 
        controllers_Application_createRoomPage8_invoker.call(controllers.Application.createRoomPage)
   }
}
        

// @LINE:16
case controllers_Application_help9_route(params) => {
   call { 
        controllers_Application_help9_invoker.call(controllers.Application.help)
   }
}
        

// @LINE:19
case controllers_Application_insert10_route(params) => {
   call { 
        controllers_Application_insert10_invoker.call(controllers.Application.insert)
   }
}
        

// @LINE:20
case controllers_Application_jsonCreateRoom11_route(params) => {
   call { 
        controllers_Application_jsonCreateRoom11_invoker.call(controllers.Application.jsonCreateRoom)
   }
}
        

// @LINE:21
case controllers_Application_createRoom12_route(params) => {
   call { 
        controllers_Application_createRoom12_invoker.call(controllers.Application.createRoom)
   }
}
        

// @LINE:22
case controllers_Application_auth13_route(params) => {
   call { 
        controllers_Application_auth13_invoker.call(controllers.Application.auth)
   }
}
        

// @LINE:23
case controllers_Application_registerUser14_route(params) => {
   call { 
        controllers_Application_registerUser14_invoker.call(controllers.Application.registerUser)
   }
}
        

// @LINE:27
case controllers_Assets_at15_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at15_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     