
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[UserData,List[String],List[RoomT],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: UserData, permission: List[String], rooms: List[RoomT])():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.66*/("""

    """),_display_(/*3.6*/main("Cat database", user.name)/*3.37*/ {_display_(Seq[Any](format.raw/*3.39*/("""


        <div class="container">
            <div class="row clearfix">
                <div class="col-md-6 column">
                    <legend>You are owner of:</legend>
                    <ul class="list-group">
                    """),_display_(/*11.22*/for(r <- rooms) yield /*11.37*/ {_display_(Seq[Any](format.raw/*11.39*/("""

                        <li id="room" class="list-group-item">
                            <label class="control-label col-sm-2" for="room">Room:</label>
                            <a data-toggle="modal" href="#modal-container-183525" class="badge" >Edit</a> """),_display_(/*15.108*/r/*15.109*/.roomName),format.raw/*15.118*/("""</li>
                    """)))}),format.raw/*16.22*/("""
                    </ul>
                </div>
                <div class="col-md-6 column">
                    <legend>You participate in:</legend>
                    <ul class="list-group">
                    """),_display_(/*22.22*/for(r <- rooms) yield /*22.37*/ {_display_(Seq[Any](format.raw/*22.39*/("""
                        <li class="list-group-item"><span class="badge">14</span> """),_display_(/*23.84*/r/*23.85*/.roomName),format.raw/*23.94*/("""</li>
                    """)))}),format.raw/*24.22*/("""
                    </ul>
                </div>
            </div>
        </div>

        <div class="modal fade" id="modal-container-183525" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type=   "button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">
                            Modal title
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default" onclick="alert ( 'Usuwam ankiete' )">Stop</button>
                        </div>
                        <div class="btn-group">
                            <button type="button" class="btn btn-info" onclick="alert ( 'Usuwam ankiete' )">Edit</button>
                        </div>
                        <div class="btn-group">
                            <button type="button" class="btn btn-danger" onclick="alert ( 'Usuwam ankiete' )">Delete</button>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            Close</button> <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>

            </div>

        </div>

    """)))}),format.raw/*60.6*/("""
"""))}
  }

  def render(user:UserData,permission:List[String],rooms:List[RoomT]): play.twirl.api.HtmlFormat.Appendable = apply(user,permission,rooms)()

  def f:((UserData,List[String],List[RoomT]) => () => play.twirl.api.HtmlFormat.Appendable) = (user,permission,rooms) => () => apply(user,permission,rooms)()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Dec 10 22:52:00 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/index.scala.html
                  HASH: cf52ae2e1a534b2d69d42b3697274f7fe0fc88e1
                  MATRIX: 532->1|684->65|716->72|755->103|794->105|1061->345|1092->360|1132->362|1423->625|1434->626|1465->635|1523->662|1768->880|1799->895|1839->897|1950->981|1960->982|1990->991|2048->1018|3720->2660
                  LINES: 19->1|22->1|24->3|24->3|24->3|32->11|32->11|32->11|36->15|36->15|36->15|37->16|43->22|43->22|43->22|44->23|44->23|44->23|45->24|81->60
                  -- GENERATED --
              */
          