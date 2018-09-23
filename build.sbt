name := "continuations_demo"

version := "0.1"

scalaVersion := "2.11.6"

autoCompilerPlugins := true

addCompilerPlugin(
  "org.scala-lang.plugins" % "scala-continuations-plugin_2.11.6" % "1.0.2")

libraryDependencies +=
  "org.scala-lang.plugins" %% "scala-continuations-library" % "1.0.2"

// This turns warnings to errors
scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Xfatal-warnings")

// This enables continuations
scalacOptions += "-P:continuations:enable"