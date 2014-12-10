
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
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Login],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: Form[Login]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.21*/("""
"""),_display_(/*2.2*/mainLogin("Cat database")/*2.27*/ {_display_(Seq[Any](format.raw/*2.29*/("""

    """),format.raw/*4.5*/("""<div class="container">
        <div class="row clearfix">
            <div class="col-md-6 column">
                <div class="jumbotron">
                    <h2>
                        Hello in Meeter
                    </h2>
                    <h3>
                        Meeter is very handy app where you can create new meeting among your freinds.
                    </h3><h3><b> To use all functionality of website you should:</b></h3>
                    <p>
                        <a class="btn btn-primary btn-large" href="/register">Register now!</a>
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
                <form class="form-horizontal" role="form" action="/auth" method="POST">
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email" value=""""),_display_(/*42.122*/form("email")/*42.135*/.value),format.raw/*42.141*/("""" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pass" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="pass" name="pass" placeholder="Password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Login</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

""")))}))}
  }

  def render(form:Form[Login]): play.twirl.api.HtmlFormat.Appendable = apply(form)

  def f:((Form[Login]) => play.twirl.api.HtmlFormat.Appendable) = (form) => apply(form)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Dec 02 23:30:30 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/login.scala.html
                  HASH: fa3adc5c0623bd23ca8c65329142520302a7db7a
                  MATRIX: 510->1|617->20|644->22|677->47|716->49|748->55|1613->893|1646->917|1686->919|1736->942|1783->973|1823->975|1876->1000|2148->1245|2162->1250|2191->1258|2244->1283|2304->1312|2354->1331|2399->1348|2824->1745|2847->1758|2875->1764
                  LINES: 19->1|22->1|23->2|23->2|23->2|25->4|46->25|46->25|46->25|48->27|48->27|48->27|49->28|52->31|52->31|52->31|53->32|55->34|57->36|58->37|63->42|63->42|63->42
                  -- GENERATED --
              */
          