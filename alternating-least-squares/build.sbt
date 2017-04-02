name := "alternating-least-squares"

version := "1.0"

scalaVersion := "2.10.5"

val spark = "org.apache.spark" % "spark-core_2.10" % "1.6.0"
val graphX = "org.apache.spark" % "spark-graphx_2.10" % "1.6.0"
val mlLib = "org.apache.spark" % "spark-mllib_2.10" % "1.6.0"

libraryDependencies ++= Seq(spark, graphX, mlLib)