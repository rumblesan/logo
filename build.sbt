name := "penrose"

organization := "com.rumblesan"

version := "0.1.0"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.12" % "test"
)

initialCommands := "import com.rumblesan.penrose._"

fork in run := true

