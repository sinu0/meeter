
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
      _display_ {import play.api.libs._


Seq[Any](format.raw/*1.66*/("""
"""),_display_(/*3.2*/main("Cat database", user.name)/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""


    <div class="container">
        <div class="row clearfix">
            <div class="col-md-6 column">
                <legend>You are owner of:</legend>
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                """),_display_(/*11.18*/for(r <- rooms) yield /*11.33*/ {_display_(Seq[Any](format.raw/*11.35*/("""
                    <div class="panel panel-default" id="room"""),_display_(/*12.63*/Crypto/*12.69*/.encryptAES(r.roomId.toString)),format.raw/*12.99*/("""">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse"""),_display_(/*15.100*/Crypto/*15.106*/.encryptAES(r.roomId.toString)),format.raw/*15.136*/("""" aria-expanded="true" aria-controls="collapse"""),_display_(/*15.183*/Crypto/*15.189*/.encryptAES(r.roomId.toString)),format.raw/*15.219*/("""">
                                    <label class="control-label col-sm-2">Room:</label> """),_display_(/*16.90*/r/*16.91*/.roomName),format.raw/*16.100*/("""
                                </a>
                                <a data-toggle="modal" href="#modal-container-183525" class="badge" style="float : right" onclick="modifyModal ( '  """),_display_(/*18.150*/Crypto/*18.156*/.encryptAES(r.roomId.toString)),format.raw/*18.186*/(""" ')" >Edit</a>
                            </h4>
                        </div>
                        <div id="collapse"""),_display_(/*21.43*/Crypto/*21.49*/.encryptAES(r.roomId.toString)),format.raw/*21.79*/("""" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading"""),_display_(/*21.154*/Crypto/*21.160*/.encryptAES(r.roomId.toString)),format.raw/*21.190*/("""">
                            <div class="panel-body">
                                <label class="control-label" for="message">Description:</label>

                                    """),_display_(/*25.38*/r/*25.39*/.message),format.raw/*25.47*/("""
                                <a style="float : right" href="/room/"""),_display_(/*26.71*/Crypto/*26.77*/.encryptAES(r.roomId.toString)),format.raw/*26.107*/("""">View more of """),_display_(/*26.123*/r/*26.124*/.roomName),format.raw/*26.133*/("""</a>
                            </div>
                        </div>
                    </div>

                """)))}),format.raw/*31.18*/("""
                </div>
            </div>
            <div class="col-md-6 column">
                <legend>You participate in:</legend>
                <ul class="list-group">
                """),_display_(/*37.18*/for(r <- rooms) yield /*37.33*/ {_display_(Seq[Any](format.raw/*37.35*/("""
                    <li id="roomP"""),_display_(/*38.35*/Crypto/*38.41*/.encryptAES(r.roomId.toString)),format.raw/*38.71*/("""" class="list-group-item"><span class="badge">14</span> """),_display_(/*38.128*/r/*38.129*/.roomName),format.raw/*38.138*/("""</li>
                """)))}),format.raw/*39.18*/("""
                </ul>
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
                    <div id="errorDiv" class="alert alert-danger" role="alert">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error:</span>
                        <span id="errorMessage"></span>
                    </div>
                    <div class="modal-body">
                        <div class="btn-group">
                            <button id="stop" type="button" class="btn btn-default" onclick="alert ( 'Usuwam ankiete' )">
                                Stop</button>
                        </div>
                        <div class="btn-group">
                            <button id="edit" type="button" class="btn btn-info" onclick="alert ( 'Usuwam ankiete' )">
                                Edit</button>
                        </div>
                        <div class="btn-group">
                            <button id="delete" type="button" class="btn btn-danger" onclick="alert ( 'Usuwam ankiete' )">
                                Delete</button>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button id="closeBtn" type="button" class="btn btn-default" data-dismiss="modal">
                            Close</button> <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>

            </div>

        </div>

    </div>


    <script>

    function modifyModal ( id ) """),format.raw/*88.33*/("""{"""),format.raw/*88.34*/(""" ;
    $ ( "#stop" ).attr ( "onclick", "stop('" + id + "')" ) ;
    $ ( "#delete" ).attr ( "onclick", "deleteSurvey('" + id + "')" ) ;
    $ ( "#edit" ).attr ( "onclick", "edit('" + id + "')" ) ;
    $ ( "#errorDiV" ).hide ( ) ;

    """),format.raw/*94.5*/("""}"""),format.raw/*94.6*/("""

    function deleteSurvey ( id ) """),format.raw/*96.34*/("""{"""),format.raw/*96.35*/("""
    $.ajax ( """),format.raw/*97.14*/("""{"""),format.raw/*97.15*/("""
    url : '/deleteRoom/' + id,
    type : 'DELETE',
    success : function ( ) """),format.raw/*100.28*/("""{"""),format.raw/*100.29*/("""
    $ ( '#closeBtn' ).click ( ) ;
    $ ( '#room' + id ).animate ( """),format.raw/*102.34*/("""{"""),format.raw/*102.35*/("""
    height : '0px'
    """),format.raw/*104.5*/("""}"""),format.raw/*104.6*/(""", """),format.raw/*104.8*/("""{"""),format.raw/*104.9*/("""
    duration : 1000,
    complete : function ( ) """),format.raw/*106.29*/("""{"""),format.raw/*106.30*/("""
    $ ( this ).remove ( ) ;
    """),format.raw/*108.5*/("""}"""),format.raw/*108.6*/("""
    """),format.raw/*109.5*/("""}"""),format.raw/*109.6*/(""" ) ;
    $ ( '#roomP' + id ).animate ( """),format.raw/*110.35*/("""{"""),format.raw/*110.36*/("""
    height : '0px'
    """),format.raw/*112.5*/("""}"""),format.raw/*112.6*/(""", """),format.raw/*112.8*/("""{"""),format.raw/*112.9*/("""
    duration : 1000,
    complete : function ( ) """),format.raw/*114.29*/("""{"""),format.raw/*114.30*/("""
    $ ( this ).remove ( ) ;
    """),format.raw/*116.5*/("""}"""),format.raw/*116.6*/("""
    """),format.raw/*117.5*/("""}"""),format.raw/*117.6*/(""" ) ;
    """),format.raw/*118.5*/("""}"""),format.raw/*118.6*/(""",
    error : function ( result ) """),format.raw/*119.33*/("""{"""),format.raw/*119.34*/("""
    $ ( "#errorMessage" ).text ( result.message )
    $ ( "#errorDiV" ).show ( 0 ).delay ( 1000 * 5 ).animate ( """),format.raw/*121.63*/("""{"""),format.raw/*121.64*/("""
    height : '0px'
    """),format.raw/*123.5*/("""}"""),format.raw/*123.6*/(""", """),format.raw/*123.8*/("""{"""),format.raw/*123.9*/("""
    duration : 1000,
    complete : function ( ) """),format.raw/*125.29*/("""{"""),format.raw/*125.30*/("""
    $ ( this ).hide ( 0 ) ;
    """),format.raw/*127.5*/("""}"""),format.raw/*127.6*/("""
    """),format.raw/*128.5*/("""}"""),format.raw/*128.6*/(""" ) ;
    """),format.raw/*129.5*/("""}"""),format.raw/*129.6*/("""

    """),format.raw/*131.5*/("""}"""),format.raw/*131.6*/(""" ) ;


    """),format.raw/*134.5*/("""}"""),format.raw/*134.6*/("""
    </script>

""")))}),format.raw/*137.2*/("""
"""))}
  }

  def render(user:UserData,permission:List[String],rooms:List[RoomT]): play.twirl.api.HtmlFormat.Appendable = apply(user,permission,rooms)()

  def f:((UserData,List[String],List[RoomT]) => () => play.twirl.api.HtmlFormat.Appendable) = (user,permission,rooms) => () => apply(user,permission,rooms)()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Dec 13 17:32:40 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/index.scala.html
                  HASH: b88269d5a2074e24b811244438fd984af311f33e
                  MATRIX: 532->1|707->65|734->91|773->122|812->124|1115->400|1146->415|1186->417|1276->480|1291->486|1342->516|1604->750|1620->756|1672->786|1747->833|1763->839|1815->869|1934->961|1944->962|1975->971|2190->1158|2206->1164|2258->1194|2407->1316|2422->1322|2473->1352|2576->1427|2592->1433|2644->1463|2861->1653|2871->1654|2900->1662|2998->1733|3013->1739|3065->1769|3109->1785|3120->1786|3151->1795|3298->1911|3520->2106|3551->2121|3591->2123|3653->2158|3668->2164|3719->2194|3804->2251|3815->2252|3846->2261|3900->2284|6068->4424|6097->4425|6358->4659|6386->4660|6449->4695|6478->4696|6520->4710|6549->4711|6658->4791|6688->4792|6785->4860|6815->4861|6867->4885|6896->4886|6926->4888|6955->4889|7034->4939|7064->4940|7125->4973|7154->4974|7187->4979|7216->4980|7284->5019|7314->5020|7366->5044|7395->5045|7425->5047|7454->5048|7533->5098|7563->5099|7624->5132|7653->5133|7686->5138|7715->5139|7752->5148|7781->5149|7844->5183|7874->5184|8016->5297|8046->5298|8098->5322|8127->5323|8157->5325|8186->5326|8265->5376|8295->5377|8356->5410|8385->5411|8418->5416|8447->5417|8484->5426|8513->5427|8547->5433|8576->5434|8615->5445|8644->5446|8692->5463
                  LINES: 19->1|23->1|24->3|24->3|24->3|32->11|32->11|32->11|33->12|33->12|33->12|36->15|36->15|36->15|36->15|36->15|36->15|37->16|37->16|37->16|39->18|39->18|39->18|42->21|42->21|42->21|42->21|42->21|42->21|46->25|46->25|46->25|47->26|47->26|47->26|47->26|47->26|47->26|52->31|58->37|58->37|58->37|59->38|59->38|59->38|59->38|59->38|59->38|60->39|109->88|109->88|115->94|115->94|117->96|117->96|118->97|118->97|121->100|121->100|123->102|123->102|125->104|125->104|125->104|125->104|127->106|127->106|129->108|129->108|130->109|130->109|131->110|131->110|133->112|133->112|133->112|133->112|135->114|135->114|137->116|137->116|138->117|138->117|139->118|139->118|140->119|140->119|142->121|142->121|144->123|144->123|144->123|144->123|146->125|146->125|148->127|148->127|149->128|149->128|150->129|150->129|152->131|152->131|155->134|155->134|158->137
                  -- GENERATED --
              */
          