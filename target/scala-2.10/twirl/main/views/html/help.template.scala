
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
object help extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Message],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: Form[Message]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.23*/("""
    """),_display_(/*2.6*/mainLogin("Cat database")/*2.31*/ {_display_(Seq[Any](format.raw/*2.33*/("""
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-6 column">
                    <legend>Get in touch.</legend>
                    <h3><small>We're approachable and would love to speak to you. <br>
                        Feel free to call, send us an email, Tweet us or simply complete the enquiry form.</small></h3>
                    <br>

                    <div class="list-group col-lg-11">
                        <ul>
                            <li class="list-group-item"><span class="glyphicon glyphicon-earphone"> <small><small><small>+</small></small>48 606734619</small></span></li>
                            <li class="list-group-item"><span class="glyphicon glyphicon-envelope"> <addres><a href="mailto:pacek@student.agh.edu.pl" ><small>pacek@student.agh.edu.pl</small></a></addres></span></li>
                        </ul>




                    </div>

                </div>
                <div class="col-md-6 column">
                    <legend>Send us a message.</legend>


                    <div class='form-group'>
                    """),_display_(/*29.22*/if(form.hasGlobalErrors)/*29.46*/ {_display_(Seq[Any](format.raw/*29.48*/("""

                        """),_display_(/*31.26*/for(error <- form.globalErrors) yield /*31.57*/ {_display_(Seq[Any](format.raw/*31.59*/("""
                            <div class="alert alert-danger" role="alert">
                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                <span class="sr-only">Error:</span>
                                """),_display_(/*35.34*/error/*35.39*/.message),format.raw/*35.47*/("""
                            </div>

                        """)))}),format.raw/*38.26*/("""

                    """)))}),format.raw/*40.22*/("""
                    </div>

                    <form class="form-horizontal" role="form" action="/sendMail" method="POST">
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Name</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="name" name="name" placeholder="Name" value=""""),_display_(/*47.122*/form("name")/*47.134*/.value),format.raw/*47.140*/("""" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="email" name="email" placeholder="Email" value=""""),_display_(/*53.126*/form("email")/*53.139*/.value),format.raw/*53.145*/("""" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pass" class="col-sm-2 control-label">Message</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="message" name="message" ></textarea>
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

  def render(form:Form[Message]): play.twirl.api.HtmlFormat.Appendable = apply(form)

  def f:((Form[Message]) => play.twirl.api.HtmlFormat.Appendable) = (form) => apply(form)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Dec 10 01:00:58 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/help.scala.html
                  HASH: 88565143269fab0bf8b3508a94db36f5c69403ac
                  MATRIX: 511->1|620->22|651->28|684->53|723->55|1990->1297|2023->1321|2063->1323|2117->1350|2164->1381|2204->1383|2517->1669|2531->1674|2560->1682|2653->1744|2707->1767|3173->2205|3195->2217|3223->2223|3640->2612|3663->2625|3691->2631
                  LINES: 19->1|22->1|23->2|23->2|23->2|50->29|50->29|50->29|52->31|52->31|52->31|56->35|56->35|56->35|59->38|61->40|68->47|68->47|68->47|74->53|74->53|74->53
                  -- GENERATED --
              */
          