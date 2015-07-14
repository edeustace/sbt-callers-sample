import sbt._
import Keys._

object Build extends sbt.Build {

  name in ThisBuild := "sbt-callers-issue"

  organization in ThisBuild := "com.ee"

  version in ThisBuild := "0.1.0-SNAPSHOT"

  val s = Defaults.defaultSettings ++ Seq(
    updateOptions := updateOptions.value.withConsolidatedResolution(true),
    libraryDependencies ++= Seq("com.ee" %% "lib-one" % "0.0.1-SNAPSHOT")
  )

  lazy val a = Project("a", file("modules/a")).settings(s)
  //lazy val b = Project("b", file("modules/b")).settings(s)

  lazy val root = Project (
    "root",
    file(".")
  )
  .settings(s)
  .dependsOn(a)
}
