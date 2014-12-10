
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
object register extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Register],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: Form[Register]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.24*/("""
"""),_display_(/*2.2*/mainLogin("Cat database")/*2.27*/ {_display_(Seq[Any](format.raw/*2.29*/("""

    """),format.raw/*4.5*/("""<div class="container">
        <div class="row clearfix">
            <div class="col-md-6 column">
                <div class="jumbotron">
                    <h2 class="text-left text-muted">
                        Hello in Meeter
                    </h2>
                    <h3 class="text-left text-muted" >
                        Meeter is very handy app where you can create new meeting among your friends.
                    </h3><h3> <b>If you are register user allready you should:</b></h3>
                    <p>
                        <a class="btn btn-primary btn-large" href="/login">Login</a>
                    </p>
                </div>
            </div>
            <div class="col-md-6 column">
                <h3 class="text-left text-muted">
                    Sing in.
                </h3>

                <div class='form-group'>
                """),_display_(/*25.18*/if(form.hasGlobalErrors)/*25.42*/ {_display_(Seq[Any](format.raw/*25.44*/("""

                    """),_display_(/*27.22*/for(error <- form.globalErrors) yield /*27.53*/ {_display_(Seq[Any](format.raw/*27.55*/("""
                        """),format.raw/*28.25*/("""<div class="alert alert-danger" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            """),_display_(/*31.30*/error/*31.35*/.message),format.raw/*31.43*/("""
                        """),format.raw/*32.25*/("""</div>

                    """)))}),format.raw/*34.22*/("""

                """)))}),format.raw/*36.18*/("""
                """),format.raw/*37.17*/("""</div>
                <form class="form-horizontal" role="form" action="/registerUser" method="POST">
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email" value=""""),_display_(/*42.122*/form("email")/*42.135*/.value),format.raw/*42.141*/("""" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="emailconf" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="emailconf" name="emailconf" placeholder="Confirm email" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pass" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="pass" name="pass" placeholder="Password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="passconf" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="passconf" name="passconf" placeholder="Confirm password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

""")))}))}
  }

  def render(form:Form[Register]): play.twirl.api.HtmlFormat.Appendable = apply(form)

  def f:((Form[Register]) => play.twirl.api.HtmlFormat.Appendable) = (form) => apply(form)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Dec 03 11:12:34 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/register.scala.html
                  HASH: 5da5c99a87e4c3f77e277ef522e3709b2c7fb3e2
                  MATRIX: 516->1|626->23|653->25|686->50|725->52|757->58|1668->942|1701->966|1741->968|1791->991|1838->1022|1878->1024|1931->1049|2203->1294|2217->1299|2246->1307|2299->1332|2359->1361|2409->1380|2454->1397|2887->1802|2910->1815|2938->1821
                  LINES: 19->1|22->1|23->2|23->2|23->2|25->4|46->25|46->25|46->25|48->27|48->27|48->27|49->28|52->31|52->31|52->31|53->32|55->34|57->36|58->37|63->42|63->42|63->42
                  -- GENERATED --
              */
          