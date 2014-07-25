name := "logo"

organization := "com.rumblesan"

version := "0.1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.13" % "test",
  "org.mockito" % "mockito-core" % "1.9.0"
)

initialCommands := "import com.rumblesan.logo._"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-language:_")

fork in run := true

