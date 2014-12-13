// @SOURCE:/home/mar/play-slick-quickstart/conf/routes
// @HASH:045a292f83a003f8ef5e68b1adc82f13e77c15cf
// @DATE:Sat Dec 13 01:31:15 CET 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
package controllers {

// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:16
def help(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "help")
}
                        

// @LINE:23
def auth(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth")
}
                        

// @LINE:13
def jsonGet(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "json/getbyid/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:22
def createRoom(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "createRoom")
}
                        

// @LINE:7
def dashboard(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:11
def room(token:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "room/" + implicitly[PathBindable[String]].unbind("token", dynamicString(token)))
}
                        

// @LINE:24
def registerUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "registerUser")
}
                        

// @LINE:17
def deleteRoom(id:String): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "deleteRoom/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:20
def insert(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "insert")
}
                        

// @LINE:12
def jsonFindAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "json/all")
}
                        

// @LINE:8
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:15
def createRoomPage(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "createRoom")
}
                        

// @LINE:14
def editRoom(token:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "edit/" + implicitly[PathBindable[String]].unbind("token", dynamicString(token)))
}
                        

// @LINE:10
def register(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "register")
}
                        

// @LINE:21
def jsonCreateRoom(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "json/")
}
                        

// @LINE:9
def login(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                        
    
}
                          
}
                  


// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:16
def help : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.help",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "help"})
      }
   """
)
                        

// @LINE:23
def auth : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.auth",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth"})
      }
   """
)
                        

// @LINE:13
def jsonGet : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.jsonGet",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "json/getbyid/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:22
def createRoom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.createRoom",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createRoom"})
      }
   """
)
                        

// @LINE:7
def dashboard : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.dashboard",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:11
def room : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.room",
   """
      function(token) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "room/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("token", encodeURIComponent(token))})
      }
   """
)
                        

// @LINE:24
def registerUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.registerUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registerUser"})
      }
   """
)
                        

// @LINE:17
def deleteRoom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteRoom",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteRoom/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:20
def insert : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.insert",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "insert"})
      }
   """
)
                        

// @LINE:12
def jsonFindAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.jsonFindAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "json/all"})
      }
   """
)
                        

// @LINE:8
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:15
def createRoomPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.createRoomPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createRoom"})
      }
   """
)
                        

// @LINE:14
def editRoom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.editRoom",
   """
      function(token) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("token", encodeURIComponent(token))})
      }
   """
)
                        

// @LINE:10
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.register",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:21
def jsonCreateRoom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.jsonCreateRoom",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "json/"})
      }
   """
)
                        

// @LINE:9
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
package controllers.ref {


// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """PUT         /json/:id               controllers.Application.
 Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:16
def help(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.help(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "help", Seq(), "GET", """""", _prefix + """help""")
)
                      

// @LINE:23
def auth(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.auth(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "auth", Seq(), "POST", """""", _prefix + """auth""")
)
                      

// @LINE:13
def jsonGet(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.jsonGet(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsonGet", Seq(classOf[Long]), "GET", """""", _prefix + """json/getbyid/$id<[^/]+>""")
)
                      

// @LINE:22
def createRoom(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.createRoom(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "createRoom", Seq(), "POST", """""", _prefix + """createRoom""")
)
                      

// @LINE:7
def dashboard(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.dashboard(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "dashboard", Seq(), "GET", """""", _prefix + """""")
)
                      

// @LINE:11
def room(token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.room(token), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "room", Seq(classOf[String]), "GET", """""", _prefix + """room/$token<[^/]+>""")
)
                      

// @LINE:24
def registerUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.registerUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "registerUser", Seq(), "POST", """""", _prefix + """registerUser""")
)
                      

// @LINE:17
def deleteRoom(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteRoom(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteRoom", Seq(classOf[String]), "DELETE", """""", _prefix + """deleteRoom/$id<[^/]+>""")
)
                      

// @LINE:20
def insert(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.insert(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "insert", Seq(), "POST", """ Home page""", _prefix + """insert""")
)
                      

// @LINE:12
def jsonFindAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.jsonFindAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsonFindAll", Seq(), "GET", """""", _prefix + """json/all""")
)
                      

// @LINE:8
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:15
def createRoomPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.createRoomPage(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "createRoomPage", Seq(), "GET", """""", _prefix + """createRoom""")
)
                      

// @LINE:14
def editRoom(token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.editRoom(token), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "editRoom", Seq(classOf[String]), "GET", """""", _prefix + """edit/$token<[^/]+>""")
)
                      

// @LINE:10
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.register(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "register", Seq(), "GET", """""", _prefix + """register""")
)
                      

// @LINE:21
def jsonCreateRoom(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.jsonCreateRoom(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsonCreateRoom", Seq(), "POST", """""", _prefix + """json/""")
)
                      

// @LINE:9
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          
}
        
    