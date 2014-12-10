
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
object createRoom extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[UserData,List[String],Form[CreateRoom],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: UserData, permission: List[String],form:Form[CreateRoom]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.66*/("""


"""),_display_(/*4.2*/main("Create meeting", user.name)/*4.35*/ {_display_(Seq[Any](format.raw/*4.37*/("""
<div class="container">
    <div class="row clearfix">
        <div class="col-md-6 column">
            <form id="createRoom" class="form-horizontal" action="/createRoom" method="POST" role="form">

                <!-- Form Name -->
                <legend>Create room</legend>
                """),_display_(/*12.18*/if(form.hasGlobalErrors)/*12.42*/ {_display_(Seq[Any](format.raw/*12.44*/("""

                    """),_display_(/*14.22*/for(error <- form.globalErrors) yield /*14.53*/ {_display_(Seq[Any](format.raw/*14.55*/("""
                        <div class="alert alert-danger" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            """),_display_(/*18.30*/error/*18.35*/.message),format.raw/*18.43*/("""
                        </div>

                    """)))}),format.raw/*21.22*/("""

                """)))}),format.raw/*23.18*/("""
                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Room name:</label>

                    <div class="col-sm-7">
                        <input id="name" name="name" type="text" placeholder="name" class="form-control" required="">

                        <p class="help-block">Name of your room</p>
                    </div>
                </div>

                <!-- Button Drop Down -->
                <div class="form-group">
                    <label class="control-label col-sm-2 " for="perm">Permission:</label>

                    <div class="col-sm-7">
                        <select id="perm" name="perm" class="form-control" form="createRoom" required="">
                            """),_display_(/*41.30*/for(perm <- permission) yield /*41.53*/ {_display_(Seq[Any](format.raw/*41.55*/("""
                            <option value="""),_display_(/*42.44*/perm),format.raw/*42.48*/(""">"""),_display_(/*42.50*/perm),format.raw/*42.54*/("""</option>
                            """)))}),format.raw/*43.30*/("""
                        </select>
                    </div>
                </div>

                <!-- Button Drop Down -->
                <div class="form-group">
                    <label class="control-label col-sm-2 " for="labelType">Type:</label>

                    <div class="col-sm-7">
                        <select id="labelType" name="labelType" class="form-control" form="createRoom" required=""
                                onclick="modifyDateFormat()">
                            <option value="year">Year</option>
                            <option value="month">Month</option>
                            <option value="day">Day</option>
                            <option value="hour">Hour</option>
                        </select>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label col-sm-2" for="dateFrom">Date from:</label>

                    <div class="col-sm-7">
                        <input id="dateFrom" name="dateFrom" type="date" placeholder="14/11/11" class="form-control"
                               value="">

                        <p class="help-block">Survey start day</p>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label col-sm-2 " for="dateTo">Date to:</label>

                    <div class="col-sm-7">
                        <input id="dateTo" name="dateTo" type="date" placeholder="14/11/12" class="form-control"
                               required="" onchange="modifyCanvas ( )">

                        <p class="help-block">Survey end day</p>
                    </div>
                </div>
                    <!-- Text input-->
                <div class="form-group">
                    <label class="control-label col-sm-2 " for="dateTo">Max value</label>

                    <div class="col-sm-7">
                        <input id="maxValue" name="maxValue" type="number" value="3" class="form-control"
                        required="" onchange="modifyCanvasNumber()" min="3" max="10">
                        <p class="help-block">Y max value</p>
                    </div>
                </div>
                <input id="labels" name="labels" type="hidden" value="">
                <!-- Button -->
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="submit" name="submit" class="btn btn-default">Create</button>
                    </div>
                </div>

            </form>
        </div>
        <div class="col-md-6 column" name="container" id="container">
            <legend>Preview:</legend>
                <script src=""""),_display_(/*108.31*/routes/*108.37*/.Assets.at("js/Chart.min.js")),format.raw/*108.66*/(""""></script>
                <script src=""""),_display_(/*109.31*/routes/*109.37*/.Assets.at("js/date.js")),format.raw/*109.61*/(""""></script>
                <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
                <canvas id="myChart" width="400" height="400"></canvas>
                <script>
                var ctx = document.getElementById("myChart").getContext("2d");

                var canvas = document.getElementById("myChart");
                var ctx = canvas.getContext("2d");
                var width = document.getElementById("container").offsetWidth;
                canvas.setAttribute("width", width);
                var data = """),format.raw/*119.28*/("""{"""),format.raw/*119.29*/("""
                    labels: ["January", "February", "March", "April", "May", "June", "July"],
                    datasets: ["""),format.raw/*121.32*/("""{"""),format.raw/*121.33*/("""
                        label: "My Second dataset",
                        fillColor: "rgba(151,187,205,0.2)",
                        strokeColor: "rgba(151,187,205,1)",
                        pointColor: "rgba(151,187,205,1)",
                        pointStrokeColor: "#fff",
                        pointHighlightFill: "#fff",
                        pointHighlightStroke: "rgba(151,187,205,1)",
                        data: [1, 1, 1, 1, 1, 1, 1]
                    """),format.raw/*130.21*/("""}"""),format.raw/*130.22*/("""
                    ]
                """),format.raw/*132.17*/("""}"""),format.raw/*132.18*/(""";
                var myNewChart = new Chart(ctx).Line(data,"""),format.raw/*133.59*/("""{"""),format.raw/*133.60*/("""
    scaleOverride: true,
    scaleSteps: 3,
    scaleStepWidth: Math.ceil(3 / 3),
    scaleStartValue: 0
"""),format.raw/*138.1*/("""}"""),format.raw/*138.2*/(""");


                canvas.onclick = function (evt) """),format.raw/*141.49*/("""{"""),format.raw/*141.50*/("""
                    var activePoints = myNewChart.getPointsAtEvent(evt);
                    var rect = canvas.getBoundingClientRect();

                    var x = evt.clientX - rect.left;
                    var y = evt.clientY - rect.top;

                """),format.raw/*148.17*/("""}"""),format.raw/*148.18*/(""";
                function modifyDateFormat() """),format.raw/*149.45*/("""{"""),format.raw/*149.46*/("""
                    switch ($('#labelType').val()) """),format.raw/*150.52*/("""{"""),format.raw/*150.53*/("""
                        case 'year':
                            $("#dateFrom").attr("type", "month");
                            $("#dateTo").attr("type", "month");
                            break;
                        case 'month':
                            $("#dateFrom").attr("type", "month");
                            $("#dateTo").attr("type", "month");
                            break;
                        case 'day':
                            $("#dateFrom").attr("type", "date");
                            $("#dateTo").attr("type", "date");
                            break;
                        case 'week':
                            $("#dateFrom").attr("type", "week");
                            $("#dateTo").attr("type", "week");
                            break;
                        case 'hour':
                            $("#dateFrom").attr("type", "time");
                            $("#dateTo").attr("type", "time");
                            break;
                    """),format.raw/*171.21*/("""}"""),format.raw/*171.22*/("""
                """),format.raw/*172.17*/("""}"""),format.raw/*172.18*/("""
                function monthDiff(d1, d2) """),format.raw/*173.44*/("""{"""),format.raw/*173.45*/("""
                    var months;
                    months = (d2.getFullYear() - d1.getFullYear()) * 12;
                    months -= d1.getMonth() + 1;
                    months += d2.getMonth();
                    return months <= 0 ? 0 : months;
                """),format.raw/*179.17*/("""}"""),format.raw/*179.18*/("""
                function createNewChart(label) """),format.raw/*180.48*/("""{"""),format.raw/*180.49*/("""
                    myNewChart.clear();
                    myNewChart.destroy();
                    myNewChart.update();
                    data.labels = label;
                    var i = 0;
                    data.datasets[0].data = [];
                    label.forEach(function (e) """),format.raw/*187.48*/("""{"""),format.raw/*187.49*/("""
                        data.datasets[0].data[i] = 1;
                        i++;
                    """),format.raw/*190.21*/("""}"""),format.raw/*190.22*/(""");
                    myNewChart = new Chart(ctx).Line(data);
                """),format.raw/*192.17*/("""}"""),format.raw/*192.18*/("""
                function modifyCanvas() """),format.raw/*193.41*/("""{"""),format.raw/*193.42*/("""
                    var dateFrom = $("#dateFrom");
                    var dateTo = $("#dateTo");
                    var objDateForm = new Date($("#dateFrom").val());
                    var objDateTo = new Date($("#dateTo").val());
                    var labelArray = [];
                    var date = 1000 * 60 * 60;
                    switch ($('#labelType').val()) """),format.raw/*200.52*/("""{"""),format.raw/*200.53*/("""
                        case 'year':

                            var years = (objDateTo - objDateForm) / (date * 24 * 365);
                            for (var i = 0; i < years; i++) """),format.raw/*204.61*/("""{"""),format.raw/*204.62*/("""
                                objDateForm.addYears(1);
                                labelArray[i] = objDateForm.toString("yyyy");
                            """),format.raw/*207.29*/("""}"""),format.raw/*207.30*/("""
                            if (i > 1) """),format.raw/*208.40*/("""{"""),format.raw/*208.41*/("""
                                createNewChart(labelArray)
                            """),format.raw/*210.29*/("""}"""),format.raw/*210.30*/("""
                            else
                                alert("Wrong date")
                            break;
                        case "month":
                            var month = monthDiff(new Date(dateFrom.val()), new Date(dateTo.val()));
                            labelArray = [];

                            if (month > 12) """),format.raw/*218.45*/("""{"""),format.raw/*218.46*/("""
                                for (var i = 0; i < month; i++) """),format.raw/*219.65*/("""{"""),format.raw/*219.66*/("""
                                    objDateForm.addMonths(1);
                                    labelArray[i] = objDateForm.toString("MMMM-yyyy");
                                """),format.raw/*222.33*/("""}"""),format.raw/*222.34*/("""
                            """),format.raw/*223.29*/("""}"""),format.raw/*223.30*/(""" else """),format.raw/*223.36*/("""{"""),format.raw/*223.37*/("""
                                for (var i = 0; i < month; i++) """),format.raw/*224.65*/("""{"""),format.raw/*224.66*/("""
                                    objDateForm.addMonths(1);
                                    labelArray[i] = objDateForm.toString("MMMM");
                                """),format.raw/*227.33*/("""}"""),format.raw/*227.34*/("""
                            """),format.raw/*228.29*/("""}"""),format.raw/*228.30*/("""

                            if (i > 1) """),format.raw/*230.40*/("""{"""),format.raw/*230.41*/("""
                                createNewChart(labelArray)
                            """),format.raw/*232.29*/("""}"""),format.raw/*232.30*/(""" else """),format.raw/*232.36*/("""{"""),format.raw/*232.37*/("""
                                alert("Wrong date range");
                            """),format.raw/*234.29*/("""}"""),format.raw/*234.30*/("""

                            break;
                        case 'day':
                            var years = (objDateTo - objDateForm) / (date * 24);
                            for (var i = 0; i < years; i++) """),format.raw/*239.61*/("""{"""),format.raw/*239.62*/("""
                                objDateForm.addDays(1);
                                labelArray[i] = objDateForm.toString("dd-MM-yyyy");
                            """),format.raw/*242.29*/("""}"""),format.raw/*242.30*/("""
                            if (i > 1) """),format.raw/*243.40*/("""{"""),format.raw/*243.41*/("""
                                createNewChart(labelArray)
                            """),format.raw/*245.29*/("""}"""),format.raw/*245.30*/("""
                            else
                                alert("Wrong date")
                            break;
                    """),format.raw/*249.21*/("""}"""),format.raw/*249.22*/("""
                    var width = document.getElementById("container").offsetWidth;
                    canvas.setAttribute("width", width);
                """),format.raw/*252.17*/("""}"""),format.raw/*252.18*/("""
                function modifyCanvasNumber()"""),format.raw/*253.46*/("""{"""),format.raw/*253.47*/("""
                    var max = $("#maxValue" ).val();
                var myNewChart = new Chart(ctx).Line(data,"""),format.raw/*255.59*/("""{"""),format.raw/*255.60*/("""
                scaleOverride: true,
                scaleSteps: max,
                scaleStepWidth: 1,
                scaleStartValue: 0
                """),format.raw/*260.17*/("""}"""),format.raw/*260.18*/(""");
                """),format.raw/*261.17*/("""}"""),format.raw/*261.18*/("""

            </script>
        </div>
    </div>
</div>
""")))}))}
  }

  def render(user:UserData,permission:List[String],form:Form[CreateRoom]): play.twirl.api.HtmlFormat.Appendable = apply(user,permission,form)

  def f:((UserData,List[String],Form[CreateRoom]) => play.twirl.api.HtmlFormat.Appendable) = (user,permission,form) => apply(user,permission,form)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Dec 08 22:27:43 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/createRoom.scala.html
                  HASH: 7ac64729b8166a0cc82718632e13a29d12872012
                  MATRIX: 542->1|694->65|723->69|764->102|803->104|1128->402|1161->426|1201->428|1251->451|1298->482|1338->484|1635->754|1649->759|1678->767|1763->821|1813->840|2639->1639|2678->1662|2718->1664|2789->1708|2814->1712|2843->1714|2868->1718|2938->1757|5827->4618|5843->4624|5894->4653|5964->4695|5980->4701|6026->4725|6603->5273|6633->5274|6788->5400|6818->5401|7322->5876|7352->5877|7420->5916|7450->5917|7539->5977|7569->5978|7703->6084|7732->6085|7814->6138|7844->6139|8133->6399|8163->6400|8238->6446|8268->6447|8349->6499|8379->6500|9433->7525|9463->7526|9509->7543|9539->7544|9612->7588|9642->7589|9940->7858|9970->7859|10047->7907|10077->7908|10397->8199|10427->8200|10560->8304|10590->8305|10698->8384|10728->8385|10798->8426|10828->8427|11231->8801|11261->8802|11476->8988|11506->8989|11699->9153|11729->9154|11798->9194|11828->9195|11945->9283|11975->9284|12354->9634|12384->9635|12478->9700|12508->9701|12719->9883|12749->9884|12807->9913|12837->9914|12872->9920|12902->9921|12996->9986|13026->9987|13232->10164|13262->10165|13320->10194|13350->10195|13420->10236|13450->10237|13567->10325|13597->10326|13632->10332|13662->10333|13779->10421|13809->10422|14052->10636|14082->10637|14280->10806|14310->10807|14379->10847|14409->10848|14526->10936|14556->10937|14726->11078|14756->11079|14941->11235|14971->11236|15046->11282|15076->11283|15217->11395|15247->11396|15433->11553|15463->11554|15511->11573|15541->11574
                  LINES: 19->1|22->1|25->4|25->4|25->4|33->12|33->12|33->12|35->14|35->14|35->14|39->18|39->18|39->18|42->21|44->23|62->41|62->41|62->41|63->42|63->42|63->42|63->42|64->43|129->108|129->108|129->108|130->109|130->109|130->109|140->119|140->119|142->121|142->121|151->130|151->130|153->132|153->132|154->133|154->133|159->138|159->138|162->141|162->141|169->148|169->148|170->149|170->149|171->150|171->150|192->171|192->171|193->172|193->172|194->173|194->173|200->179|200->179|201->180|201->180|208->187|208->187|211->190|211->190|213->192|213->192|214->193|214->193|221->200|221->200|225->204|225->204|228->207|228->207|229->208|229->208|231->210|231->210|239->218|239->218|240->219|240->219|243->222|243->222|244->223|244->223|244->223|244->223|245->224|245->224|248->227|248->227|249->228|249->228|251->230|251->230|253->232|253->232|253->232|253->232|255->234|255->234|260->239|260->239|263->242|263->242|264->243|264->243|266->245|266->245|270->249|270->249|273->252|273->252|274->253|274->253|276->255|276->255|281->260|281->260|282->261|282->261
                  -- GENERATED --
              */
          