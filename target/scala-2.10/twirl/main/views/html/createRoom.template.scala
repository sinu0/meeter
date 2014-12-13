
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
  def apply/*1.2*/(user: UserData, permission: List[String], form: Form[CreateRoom]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.68*/("""


    """),_display_(/*4.6*/main("Create meeting", user.name)/*4.39*/ {_display_(Seq[Any](format.raw/*4.41*/("""
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-6 column">
                    <form id="createRoom" class="form-horizontal" action="/createRoom" method="POST" role="form">

                            <!-- Form Name -->
                        <legend>Create room</legend>
                        """),_display_(/*12.26*/if(form.hasGlobalErrors)/*12.50*/ {_display_(Seq[Any](format.raw/*12.52*/("""

                            """),_display_(/*14.30*/for(error <- form.globalErrors) yield /*14.61*/ {_display_(Seq[Any](format.raw/*14.63*/("""
                                <div class="alert alert-danger" role="alert">
                                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                    <span class="sr-only">Error:</span>
                                    """),_display_(/*18.38*/error/*18.43*/.message),format.raw/*18.51*/("""
                                </div>

                            """)))}),format.raw/*21.30*/("""

                        """)))}),format.raw/*23.26*/("""
                            <!-- Text input-->
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="name">Room name:</label>

                            <div class="col-sm-7">
                                <input id="name" name="name" type="text" placeholder="name" class="form-control" required="">

                                <p class="help-block">Name of your room</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="name">Short description:</label>

                            <div class="col-sm-7">
                                <textarea id="message" name="message" type="text" placeholder="Description" class="form-control"></textarea>
                            </div>
                        </div>
                            <!-- Button Drop Down -->
                        <div class="form-group">
                            <label class="control-label col-sm-2 " for="perm">Permission:</label>

                            <div class="col-sm-7">
                                <select id="perm" name="perm" class="form-control" form="createRoom" required="">
                                """),_display_(/*47.34*/for(perm <- permission) yield /*47.57*/ {_display_(Seq[Any](format.raw/*47.59*/("""
                                    <option value="""),_display_(/*48.52*/perm),format.raw/*48.56*/(""">"""),_display_(/*48.58*/perm),format.raw/*48.62*/("""</option>
                                """)))}),format.raw/*49.34*/("""
                                </select>
                            </div>
                        </div>

                            <!-- Button Drop Down -->
                        <div class="form-group">
                            <label class="control-label col-sm-2 " for="labelType">Type:</label>

                            <div class="col-sm-7">
                                <select id="labelType" name="labelType" class="form-control" form="createRoom" required=""
                                onclick="modifyDateFormat ( )">
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

                                <p class="help-block">Survey end date</p>
                            </div>
                        </div>
                            <!-- Text input-->
                        <div class="form-group">
                            <label class="control-label col-sm-2 " for="dateTo">Max value</label>

                            <div class="col-sm-7">
                                <input id="maxValue" name="maxValue" type="number" value="3" class="form-control"
                                required="" onchange="modifyCanvasNumber ( )" min="3" max="10">
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
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="name">Survey end day</label>

                            <div class="col-sm-7">
                                <input id="endDay" name="endDay" type="datetime-local" class="form-control" required="">

                                <p class="help-block">Time of survey to end</p>
                            </div>
                        </div>
                    </form>
                </div>
        <div class="col-md-6 column" name="container" id="container">
            <legend>Preview:</legend>
                <script src=""""),_display_(/*122.31*/routes/*122.37*/.Assets.at("js/Chart.min.js")),format.raw/*122.66*/(""""></script>
                <script src=""""),_display_(/*123.31*/routes/*123.37*/.Assets.at("js/date.js")),format.raw/*123.61*/(""""></script>
                <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
                <canvas id="myChart" width="400" height="400"></canvas>
                <script>
                var ctx = document.getElementById("myChart").getContext("2d");

                var canvas = document.getElementById("myChart");
                var ctx = canvas.getContext("2d");
                var width = document.getElementById("container").offsetWidth;
                canvas.setAttribute("width", width);
                var data = """),format.raw/*133.28*/("""{"""),format.raw/*133.29*/("""
                    labels: ["January", "February", "March", "April", "May", "June", "July"],
                    datasets: ["""),format.raw/*135.32*/("""{"""),format.raw/*135.33*/("""
                        label: "My Second dataset",
                        fillColor: "rgba(151,187,205,0.2)",
                        strokeColor: "rgba(151,187,205,1)",
                        pointColor: "rgba(151,187,205,1)",
                        pointStrokeColor: "#fff",
                        pointHighlightFill: "#fff",
                        pointHighlightStroke: "rgba(151,187,205,1)",
                        data: [1, 1, 1, 1, 1, 1, 1]
                    """),format.raw/*144.21*/("""}"""),format.raw/*144.22*/("""
                    ]
                """),format.raw/*146.17*/("""}"""),format.raw/*146.18*/(""";
                var myNewChart = new Chart(ctx).Line(data,"""),format.raw/*147.59*/("""{"""),format.raw/*147.60*/("""
    scaleOverride: true,
    scaleSteps: 3,
    scaleStepWidth: Math.ceil(3 / 3),
    scaleStartValue: 0
"""),format.raw/*152.1*/("""}"""),format.raw/*152.2*/(""");


                canvas.onclick = function (evt) """),format.raw/*155.49*/("""{"""),format.raw/*155.50*/("""
                    var activePoints = myNewChart.getPointsAtEvent(evt);
                    var rect = canvas.getBoundingClientRect();

                    var x = evt.clientX - rect.left;
                    var y = evt.clientY - rect.top;

                """),format.raw/*162.17*/("""}"""),format.raw/*162.18*/(""";
                function modifyDateFormat() """),format.raw/*163.45*/("""{"""),format.raw/*163.46*/("""
                    switch ($('#labelType').val()) """),format.raw/*164.52*/("""{"""),format.raw/*164.53*/("""
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
                    """),format.raw/*185.21*/("""}"""),format.raw/*185.22*/("""
                """),format.raw/*186.17*/("""}"""),format.raw/*186.18*/("""
                function monthDiff(d1, d2) """),format.raw/*187.44*/("""{"""),format.raw/*187.45*/("""
                    var months;
                    months = (d2.getFullYear() - d1.getFullYear()) * 12;
                    months -= d1.getMonth() + 1;
                    months += d2.getMonth();
                    return months <= 0 ? 0 : months;
                """),format.raw/*193.17*/("""}"""),format.raw/*193.18*/("""
                function createNewChart(label) """),format.raw/*194.48*/("""{"""),format.raw/*194.49*/("""
                    myNewChart.clear();
                    myNewChart.destroy();
                    myNewChart.update();
                    data.labels = label;
                    var i = 0;
                    data.datasets[0].data = [];
                    label.forEach(function (e) """),format.raw/*201.48*/("""{"""),format.raw/*201.49*/("""
                        data.datasets[0].data[i] = 1;
                        i++;
                    """),format.raw/*204.21*/("""}"""),format.raw/*204.22*/(""");
                    myNewChart = new Chart(ctx).Line(data);
                """),format.raw/*206.17*/("""}"""),format.raw/*206.18*/("""
                function modifyCanvas() """),format.raw/*207.41*/("""{"""),format.raw/*207.42*/("""
                    var dateFrom = $("#dateFrom");
                    var dateTo = $("#dateTo");
                    var objDateForm = new Date($("#dateFrom").val());
                    var objDateTo = new Date($("#dateTo").val());
                    var labelArray = [];
                    var date = 1000 * 60 * 60;
                    switch ($('#labelType').val()) """),format.raw/*214.52*/("""{"""),format.raw/*214.53*/("""
                        case 'year':

                            var years = (objDateTo - objDateForm) / (date * 24 * 365);
                            for (var i = 0; i < years; i++) """),format.raw/*218.61*/("""{"""),format.raw/*218.62*/("""
                                objDateForm.addYears(1);
                                labelArray[i] = objDateForm.toString("yyyy");
                            """),format.raw/*221.29*/("""}"""),format.raw/*221.30*/("""
                            if (i > 1) """),format.raw/*222.40*/("""{"""),format.raw/*222.41*/("""
                                createNewChart(labelArray)
                            """),format.raw/*224.29*/("""}"""),format.raw/*224.30*/("""
                            else
                                alert("Wrong date")
                            break;
                        case "month":
                            var month = monthDiff(new Date(dateFrom.val()), new Date(dateTo.val()));
                            labelArray = [];

                            if (month > 12) """),format.raw/*232.45*/("""{"""),format.raw/*232.46*/("""
                                for (var i = 0; i < month; i++) """),format.raw/*233.65*/("""{"""),format.raw/*233.66*/("""
                                    objDateForm.addMonths(1);
                                    labelArray[i] = objDateForm.toString("MMMM-yyyy");
                                """),format.raw/*236.33*/("""}"""),format.raw/*236.34*/("""
                            """),format.raw/*237.29*/("""}"""),format.raw/*237.30*/(""" else """),format.raw/*237.36*/("""{"""),format.raw/*237.37*/("""
                                for (var i = 0; i < month; i++) """),format.raw/*238.65*/("""{"""),format.raw/*238.66*/("""
                                    objDateForm.addMonths(1);
                                    labelArray[i] = objDateForm.toString("MMMM");
                                """),format.raw/*241.33*/("""}"""),format.raw/*241.34*/("""
                            """),format.raw/*242.29*/("""}"""),format.raw/*242.30*/("""

                            if (i > 1) """),format.raw/*244.40*/("""{"""),format.raw/*244.41*/("""
                                createNewChart(labelArray)
                            """),format.raw/*246.29*/("""}"""),format.raw/*246.30*/(""" else """),format.raw/*246.36*/("""{"""),format.raw/*246.37*/("""
                                alert("Wrong date range");
                            """),format.raw/*248.29*/("""}"""),format.raw/*248.30*/("""

                            break;
                        case 'day':
                            var years = (objDateTo - objDateForm) / (date * 24);
                            for (var i = 0; i < years; i++) """),format.raw/*253.61*/("""{"""),format.raw/*253.62*/("""
                                objDateForm.addDays(1);
                                labelArray[i] = objDateForm.toString("dd-MM-yyyy");
                            """),format.raw/*256.29*/("""}"""),format.raw/*256.30*/("""
                            if (i > 1) """),format.raw/*257.40*/("""{"""),format.raw/*257.41*/("""
                                createNewChart(labelArray)
                            """),format.raw/*259.29*/("""}"""),format.raw/*259.30*/("""
                            else
                                alert("Wrong date")
                            break;
                    """),format.raw/*263.21*/("""}"""),format.raw/*263.22*/("""
                    var width = document.getElementById("container").offsetWidth;
                    canvas.setAttribute("width", width);
                """),format.raw/*266.17*/("""}"""),format.raw/*266.18*/("""
                function modifyCanvasNumber()"""),format.raw/*267.46*/("""{"""),format.raw/*267.47*/("""
                    var max = $("#maxValue" ).val();
                var myNewChart = new Chart(ctx).Line(data,"""),format.raw/*269.59*/("""{"""),format.raw/*269.60*/("""
                scaleOverride: true,
                scaleSteps: max,
                scaleStepWidth: 1,
                scaleStartValue: 0
                """),format.raw/*274.17*/("""}"""),format.raw/*274.18*/(""");
                """),format.raw/*275.17*/("""}"""),format.raw/*275.18*/("""

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
                  DATE: Sat Dec 13 17:43:22 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/createRoom.scala.html
                  HASH: b192ef0e3f4ed69bc79ec19ee8af30d092ffcece
                  MATRIX: 542->1|696->67|729->75|770->108|809->110|1194->468|1227->492|1267->494|1325->525|1372->556|1412->558|1741->860|1755->865|1784->873|1885->943|1943->970|3296->2296|3335->2319|3375->2321|3454->2373|3479->2377|3508->2379|3533->2383|3607->2426|7379->6170|7395->6176|7446->6205|7516->6247|7532->6253|7578->6277|8155->6825|8185->6826|8340->6952|8370->6953|8874->7428|8904->7429|8972->7468|9002->7469|9091->7529|9121->7530|9255->7636|9284->7637|9366->7690|9396->7691|9685->7951|9715->7952|9790->7998|9820->7999|9901->8051|9931->8052|10985->9077|11015->9078|11061->9095|11091->9096|11164->9140|11194->9141|11492->9410|11522->9411|11599->9459|11629->9460|11949->9751|11979->9752|12112->9856|12142->9857|12250->9936|12280->9937|12350->9978|12380->9979|12783->10353|12813->10354|13028->10540|13058->10541|13251->10705|13281->10706|13350->10746|13380->10747|13497->10835|13527->10836|13906->11186|13936->11187|14030->11252|14060->11253|14271->11435|14301->11436|14359->11465|14389->11466|14424->11472|14454->11473|14548->11538|14578->11539|14784->11716|14814->11717|14872->11746|14902->11747|14972->11788|15002->11789|15119->11877|15149->11878|15184->11884|15214->11885|15331->11973|15361->11974|15604->12188|15634->12189|15832->12358|15862->12359|15931->12399|15961->12400|16078->12488|16108->12489|16278->12630|16308->12631|16493->12787|16523->12788|16598->12834|16628->12835|16769->12947|16799->12948|16985->13105|17015->13106|17063->13125|17093->13126
                  LINES: 19->1|22->1|25->4|25->4|25->4|33->12|33->12|33->12|35->14|35->14|35->14|39->18|39->18|39->18|42->21|44->23|68->47|68->47|68->47|69->48|69->48|69->48|69->48|70->49|143->122|143->122|143->122|144->123|144->123|144->123|154->133|154->133|156->135|156->135|165->144|165->144|167->146|167->146|168->147|168->147|173->152|173->152|176->155|176->155|183->162|183->162|184->163|184->163|185->164|185->164|206->185|206->185|207->186|207->186|208->187|208->187|214->193|214->193|215->194|215->194|222->201|222->201|225->204|225->204|227->206|227->206|228->207|228->207|235->214|235->214|239->218|239->218|242->221|242->221|243->222|243->222|245->224|245->224|253->232|253->232|254->233|254->233|257->236|257->236|258->237|258->237|258->237|258->237|259->238|259->238|262->241|262->241|263->242|263->242|265->244|265->244|267->246|267->246|267->246|267->246|269->248|269->248|274->253|274->253|277->256|277->256|278->257|278->257|280->259|280->259|284->263|284->263|287->266|287->266|288->267|288->267|290->269|290->269|295->274|295->274|296->275|296->275
                  -- GENERATED --
              */
          