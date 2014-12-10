
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, name: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.46*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Bootstrap Login Form</title>
        <meta name="generator" content="Bootply"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href= """"),_display_(/*13.23*/routes/*13.29*/.Assets.at("css/bootstrap.css")),format.raw/*13.60*/("""" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src=""""),_display_(/*15.23*/routes/*15.29*/.Assets.at("js/bootstrap.js")),format.raw/*15.58*/(""""></script>
        <script src=""""),_display_(/*16.23*/routes/*16.29*/.Assets.at("js/jquery.smartmenus.bootstrap.js")),format.raw/*16.76*/(""""></script>

            <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
        <link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.at("css/styles.css")),format.raw/*21.56*/("""" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">Meetings</a>
                </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="/createRoom">Create survey<span class="sr-only">(current)</span></a></li>
                        <li><a href="/manageSurvey">Manage survey</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Hello """),_display_(/*45.48*/name),format.raw/*45.52*/("""</a></li>
                        <li class="dropdown">
                            <a href="#" class="glyphicon glyphicon-user" data-toggle="dropdown" role="button" aria-expanded="false"> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li class="divider"></li>
                                <li><a href="/logout">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div> <!-- /.navbar-collapse -->
            </div> <!-- /.container-fluid -->
        </nav>

        """),_display_(/*58.10*/content),format.raw/*58.17*/("""

    </body>
</html>"""))}
  }

  def render(title:String,name:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,name)(content)

  def f:((String,String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,name) => (content) => apply(title,name)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Dec 07 18:49:49 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/main.scala.html
                  HASH: d2ff18fa659eb9f95dfa0fd97e38ad323adb8b6c
                  MATRIX: 516->1|648->45|727->98|752->103|1106->430|1121->436|1173->467|1319->586|1334->592|1384->621|1445->655|1460->661|1528->708|1710->863|1725->869|1774->897|3122->2218|3147->2222|3801->2849|3829->2856
                  LINES: 19->1|22->1|28->7|28->7|34->13|34->13|34->13|36->15|36->15|36->15|37->16|37->16|37->16|42->21|42->21|42->21|66->45|66->45|79->58|79->58
                  -- GENERATED --
              */
          