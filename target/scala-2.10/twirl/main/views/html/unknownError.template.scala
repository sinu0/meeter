
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
object unknownError extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(error:String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),_display_(/*3.2*/mainLogin("Unknown error")/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""

    """),format.raw/*5.5*/("""<div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="error-template">
                    <h1>
                        Oops!</h1>
                    <h2>
                        500 Internal Server Error</h2>
                    <div class="error-details">
                        Unknown error """),_display_(/*14.40*/error),format.raw/*14.45*/("""
                    """),format.raw/*15.21*/("""</div>
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

  def render(error:String): play.twirl.api.HtmlFormat.Appendable = apply(error)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (error) => apply(error)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Dec 03 16:37:13 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/unknownError.scala.html
                  HASH: 899350bdb9eb00b16acb989891ea6f1b76e276fd
                  MATRIX: 512->1|614->15|642->18|676->44|715->46|747->52|1132->410|1158->415|1207->436
                  LINES: 19->1|22->1|24->3|24->3|24->3|26->5|35->14|35->14|36->15
                  -- GENERATED --
              */
          