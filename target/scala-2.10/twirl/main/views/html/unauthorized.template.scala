
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
object unauthorized extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/mainLogin("Unknown error")/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""

    """),format.raw/*5.5*/("""<div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="error-template">
                    <h1>
                        Oops!</h1>
                    <h2>
                        401 Unauthorized operation</h2>
                    <div class="error-details">
                        You don't have enough permission to see this content!
                    </div>
                    <div class="error-actions">
                        <a href="/" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                            Take Me Home </a><a href="/help" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Contact Support </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Dec 03 16:37:13 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/unauthorized.scala.html
                  HASH: 66c03cb340e8cf269258843c17752ec90ffc7cb0
                  MATRIX: 505->1|594->3|622->6|656->32|695->34|727->40
                  LINES: 19->1|22->1|24->3|24->3|24->3|26->5
                  -- GENERATED --
              */
          