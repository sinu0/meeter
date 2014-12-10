
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
object mainLogged extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.32*/("""

"""),format.raw/*4.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*8.17*/title),format.raw/*8.22*/("""</title>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Bootstrap Login Form</title>
        <meta name="generator" content="Bootply"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href= """"),_display_(/*14.23*/routes/*14.29*/.Assets.at("css/bootstrap.min.css")),format.raw/*14.64*/("""" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src=""""),_display_(/*16.23*/routes/*16.29*/.Assets.at("js/bootstrap.js")),format.raw/*16.58*/(""""></script>
        <script src=""""),_display_(/*17.23*/routes/*17.29*/.Assets.at("js/jquery.smartmenus.bootstrap.js")),format.raw/*17.76*/(""""></script>

            <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
        <link href=""""),_display_(/*22.22*/routes/*22.28*/.Assets.at("css/styles.css")),format.raw/*22.56*/("""" rel="stylesheet">
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
                        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Link</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                                <li class="divider"></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Hello</a></li>
                        <li class="dropdown">
                            <a href="#" class="glyphicon glyphicon-user" data-toggle="dropdown" role="button" aria-expanded="false"> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="/login">Login</a></li>
                                <li><a href="/register">Register</a></li>
                                <li class="divider"></li>
                                <li><a href="/help">Help</a></li>
                            </ul>
                        </li>
                    </ul>
                </div> <!-- /.navbar-collapse -->
            </div> <!-- /.container-fluid -->
        </nav>
        """),_display_(/*72.10*/content),format.raw/*72.17*/("""
    """),format.raw/*73.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Nov 27 20:37:28 CET 2014
                  SOURCE: /home/mar/play-slick-quickstart/app/views/mainLogin.scala.html
                  HASH: 72b5beac470249c340c8d3a65ea16ec4a82931a8
                  MATRIX: 515->2|633->32|661->34|738->85|763->90|1117->417|1132->423|1188->458|1334->577|1349->583|1399->612|1460->646|1475->652|1543->699|1725->854|1740->860|1789->888|4698->3770|4726->3777|4758->3782
                  LINES: 19->2|22->2|24->4|28->8|28->8|34->14|34->14|34->14|36->16|36->16|36->16|37->17|37->17|37->17|42->22|42->22|42->22|92->72|92->72|93->73
                  -- GENERATED --
              */
          