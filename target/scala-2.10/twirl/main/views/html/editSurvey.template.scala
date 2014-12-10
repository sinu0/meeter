
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
object editSurvey extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Cat database","s")/*3.26*/ {_display_(Seq[Any](format.raw/*3.28*/("""
    """),format.raw/*4.5*/("""<script src=""""),_display_(/*4.19*/routes/*4.25*/.Assets.at("js/Chart.min.js")),format.raw/*4.54*/(""""></script>
    <canvas id="myChart" width="400" height="400"></canvas>
    <script>var ctx = document.getElementById("myChart").getContext("2d");

    var canvas = document.getElementById("myChart");
    var ctx = canvas.getContext("2d");
    var width = document.getElementById("container").offsetWidth;
    canvas.setAttribute("width",width);
    var data = """),format.raw/*12.16*/("""{"""),format.raw/*12.17*/("""
    """),format.raw/*13.5*/("""labels: ["January", "February", "March", "April", "May", "June", "July"],
    datasets: [

    """),format.raw/*16.5*/("""{"""),format.raw/*16.6*/("""
    """),format.raw/*17.5*/("""label: "My Second dataset",
    fillColor: "rgba(151,187,205,0.2)",
    strokeColor: "rgba(151,187,205,1)",
    pointColor: "rgba(151,187,205,1)",
    pointStrokeColor: "#fff",
    pointHighlightFill: "#fff",
    pointHighlightStroke: "rgba(151,187,205,1)",
    data: [28, 48, 40, 19, 86, 27, 90]
    """),format.raw/*25.5*/("""}"""),format.raw/*25.6*/("""
    """),format.raw/*26.5*/("""]
    """),format.raw/*27.5*/("""}"""),format.raw/*27.6*/(""";
    var myNewChart = new Chart(ctx).Line(data);
     canvas.onclick = function(evt)"""),format.raw/*29.36*/("""{"""),format.raw/*29.37*/("""
    """),format.raw/*30.5*/("""var activePoints = myNewChart.getPointsAtEvent(evt);
     var rect = canvas.getBoundingClientRect();

     var x = evt.clientX - rect.left;
     var y = evt.clientY - rect.top;

"""),format.raw/*36.1*/("""}"""),format.raw/*36.2*/(""";

    </script>
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Dec 03 11:20:31 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/editSurvey.scala.html
                  HASH: e7129db21e074d3c625da01d8c00b3a50d870a51
                  MATRIX: 503->1|592->3|620->6|652->30|691->32|722->37|762->51|776->57|825->86|1214->447|1243->448|1275->453|1397->548|1425->549|1457->554|1785->855|1813->856|1845->861|1878->867|1906->868|2019->953|2048->954|2080->959|2285->1137|2313->1138
                  LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|25->4|33->12|33->12|34->13|37->16|37->16|38->17|46->25|46->25|47->26|48->27|48->27|50->29|50->29|51->30|57->36|57->36
                  -- GENERATED --
              */
          