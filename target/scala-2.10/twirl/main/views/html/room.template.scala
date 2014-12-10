
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object room extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[List[scala.Tuple3[Long, String, String]],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userDataList:List[(Long,String,String)],perm:String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.55*/("""

"""),_display_(/*3.2*/main("Cat database","s")/*3.26*/ {_display_(Seq[Any](format.raw/*3.28*/("""

""")))}))}
  }

  def render(userDataList:List[scala.Tuple3[Long, String, String]],perm:String): play.twirl.api.HtmlFormat.Appendable = apply(userDataList,perm)

  def f:((List[scala.Tuple3[Long, String, String]],String) => play.twirl.api.HtmlFormat.Appendable) = (userDataList,perm) => apply(userDataList,perm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Nov 27 19:35:19 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/room.scala.html
                  HASH: 240972fb12b019d550effc7f45f22fbe36e490f0
                  MATRIX: 545->1|686->54|714->57|746->81|785->83
                  LINES: 19->1|22->1|24->3|24->3|24->3
                  -- GENERATED --
              */
          