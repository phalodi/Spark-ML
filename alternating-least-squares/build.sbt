name := "alternating-least-squares"

version := "1.0"

scalaVersion := "2.11.8"

val spark = "org.apache.spark" % "spark-core_2.11" % "1.6.0"
val graphX = "org.apache.spark" % "spark-graphx_2.11" % "1.6.0"
val mlLib = "org.apache.spark" % "spark-mllib_2.11" % "1.6.0"

libraryDependencies ++= Seq(spark, graphX, mlLib)