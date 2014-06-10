package week1
import week1._

object funs {
  println("Welcome to the Scala worksheet")

  val f: (Int => String) = List("a", "b", "c")
  f(2)
  
  val fun: PartialFunction[String, String] = { case "ping" => "pong" }
  fun("ping")
  fun.isDefinedAt("ping")

   val integers = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  }
  
 
}