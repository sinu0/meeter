import java.io.File
import play.PlayImport.PlayKeys._
import play.PlayScala
import play.twirl.sbt.Import.TwirlKeys
import play.PlayJava
name := """play-slick-quickstart"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.4"

resolvers += Resolver.file("LocalIvy", file(Path.userHome + File.separator + ".ivy2" + File.separator + "local"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.2.2",
  "com.typesafe.play" %% "play-slick" % "0.7.0",
  "com.feth" % "play-easymail_2.10" % "0.6.7",
  javaCore
)



resolvers ++= Seq(
  "play-easymail (release)" at "http://joscha.github.io/play-easymail/repo/releases/",
  "play-easymail (snapshot)" at "http://joscha.github.io/play-easymail/repo/snapshots/"
)

fork in Test := false

lazy val root = (project in file(".")).enablePlugins(PlayScala)

TwirlKeys.useOldParser := true