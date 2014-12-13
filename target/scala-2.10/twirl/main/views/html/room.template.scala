
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
object room extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[List[scala.Tuple3[Long, String, String]],String,java.util.Date,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userDataList:List[(Long,String,String)],perm:String,endTime:java.util.Date):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.78*/("""

"""),_display_(/*3.2*/main("Cat database","s")/*3.26*/ {_display_(Seq[Any](format.raw/*3.28*/("""
<div>"""),_display_(/*4.7*/endTime),format.raw/*4.14*/("""</div>
""")))}))}
  }

  def render(userDataList:List[scala.Tuple3[Long, String, String]],perm:String,endTime:java.util.Date): play.twirl.api.HtmlFormat.Appendable = apply(userDataList,perm,endTime)

  def f:((List[scala.Tuple3[Long, String, String]],String,java.util.Date) => play.twirl.api.HtmlFormat.Appendable) = (userDataList,perm,endTime) => apply(userDataList,perm,endTime)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Dec 13 17:32:40 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/room.scala.html
                  HASH: 262234b6b26e7a1897e724577b5ed6c45977cda2
                  MATRIX: 560->1|724->77|752->80|784->104|823->106|855->113|882->120
                  LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4
                  -- GENERATED --
              */
          