
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

                        <li id="room"""),_display_(/*13.38*/r/*13.39*/.roomId),format.raw/*13.46*/("""" class="list-group-item">
                            <label class="control-label col-sm-2" for="room">Room:</label>
                            <a data-toggle="modal" href="#modal-container-183525" class="badge" onclick="modifyModal("""),_display_(/*15.119*/r/*15.120*/.roomId),format.raw/*15.127*/(""")" >Edit</a> """),_display_(/*15.141*/r/*15.142*/.roomName),format.raw/*15.151*/("""</li>
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
                            <button id="stop" type="button" class="btn btn-default" onclick="alert ( 'Usuwam ankiete' )">Stop</button>
                        </div>
                        <div class="btn-group">
                            <button id="edit" type="button" class="btn btn-info" onclick="alert ( 'Usuwam ankiete' )">Edit</button>
                        </div>
                        <div class="btn-group">
                            <button id="delete" type="button" class="btn btn-danger" onclick="alert ( 'Usuwam ankiete' )">Delete</button>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button id="closeBtn" type="button" class="btn btn-default" data-dismiss="modal">
                            Close</button> <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>

            </div>

        </div>
    <script>
        function modifyModal(id)"""),format.raw/*60.33*/("""{"""),format.raw/*60.34*/("""
            $("#stop" ).attr("onclick","stop("+id+")");
            $("#delete" ).attr("onclick","deleteSurvey("+id+")");
            $("#edit" ).attr("onclick","edit("+id+")");
            alert("works!" + id);
        """),format.raw/*65.9*/("""}"""),format.raw/*65.10*/("""

        function deleteSurvey(id)"""),format.raw/*67.34*/("""{"""),format.raw/*67.35*/("""
            $('#closeBtn' ).click();
            $('#room'+id ).animate("""),format.raw/*69.36*/("""{"""),format.raw/*69.37*/("""
                width: '0px'
            """),format.raw/*71.13*/("""}"""),format.raw/*71.14*/(""", """),format.raw/*71.16*/("""{"""),format.raw/*71.17*/("""
                duration: 1000,
                complete: function() """),format.raw/*73.38*/("""{"""),format.raw/*73.39*/("""
                    $(this).remove();
                """),format.raw/*75.17*/("""}"""),format.raw/*75.18*/("""
            """),format.raw/*76.13*/("""}"""),format.raw/*76.14*/(""");

        """),format.raw/*78.9*/("""}"""),format.raw/*78.10*/("""
    </script>

    """)))}),format.raw/*81.6*/("""
"""))}
  }

  def render(user:UserData,permission:List[String],rooms:List[RoomT]): play.twirl.api.HtmlFormat.Appendable = apply(user,permission,rooms)()

  def f:((UserData,List[String],List[RoomT]) => () => play.twirl.api.HtmlFormat.Appendable) = (user,permission,rooms) => () => apply(user,permission,rooms)()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Dec 12 00:41:03 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/index.scala.html
                  HASH: e69f5ac62d26e19ea7423fcc0ba9d9a8547b9420
                  MATRIX: 532->1|684->65|716->72|755->103|794->105|1061->345|1092->360|1132->362|1198->401|1208->402|1236->409|1500->645|1511->646|1540->653|1582->667|1593->668|1624->677|1682->704|1927->922|1958->937|1998->939|2109->1023|2119->1024|2149->1033|2207->1060|3962->2787|3991->2788|4239->3009|4268->3010|4331->3045|4360->3046|4461->3119|4490->3120|4560->3162|4589->3163|4619->3165|4648->3166|4746->3236|4775->3237|4858->3292|4887->3293|4928->3306|4957->3307|4996->3319|5025->3320|5076->3341
                  LINES: 19->1|22->1|24->3|24->3|24->3|32->11|32->11|32->11|34->13|34->13|34->13|36->15|36->15|36->15|36->15|36->15|36->15|37->16|43->22|43->22|43->22|44->23|44->23|44->23|45->24|81->60|81->60|86->65|86->65|88->67|88->67|90->69|90->69|92->71|92->71|92->71|92->71|94->73|94->73|96->75|96->75|97->76|97->76|99->78|99->78|102->81
                  -- GENERATED --
              */
          