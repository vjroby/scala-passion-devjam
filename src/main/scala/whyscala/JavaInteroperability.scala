package whyscala

import java.util
// use this import to have collections interoperability with Java
import scala.jdk.CollectionConverters._
// import for infix
import scala.language.postfixOps

object JavaInteroperability extends App {

  val range =  (10 to 15)

  val javaList = new util.ArrayList[Int]()
  range.foreach(javaList.add)

  val scalaList = range.toList

  println(s"Scala list: ${scalaList.getClass}, el: ${scalaList.mkString(",")}")
  println(s"Java list: ${javaList.getClass}, el: ${javaList.asScala.mkString(",")}")

  // scala infix notation
  val newList = (scalaList ++ javaList.asScala) sorted

  println(s"New list in scala: ${newList.getClass}, el: ${newList.mkString(",")}")

  newList.asJava
}
