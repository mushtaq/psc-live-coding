name := "pune-scala-symposium"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "com.typesafe.play" % "play_2.10" % "2.2.2",
  "org.scala-lang.modules" %% "scala-async" % "0.9.0",
  "com.netflix.rxjava" % "rxjava-scala" % "0.17.4",
  "org.specs2" %% "specs2" % "2.3.10" % "test"
)

transitiveClassifiers in Global := Seq(Artifact.SourceClassifier)
