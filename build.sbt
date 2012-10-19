name := "logo"

organization := "com.rumblesan"

version := "0.1.0"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.12" % "test",
  "org.mockito" % "mockito-core" % "1.9.0"
)

initialCommands := "import com.rumblesan.logo._"

fork in run := true

