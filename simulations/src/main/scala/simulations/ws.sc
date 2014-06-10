package simulations
import common._
import org.scalatest.FlatSpec

object ws {
  println("Welcome to the Scala worksheet")
  
  List(1)  match {
  case x :: xs => 1
  case _ => 0
  }
  
  1 :: List()
  
 val w = new Wire
 
  def makeWires(n: Int): List[Wire] = {
    if (n == 0) List() else
      new Wire :: makeWires(n - 1)
  }
  
  makeWires(5)
  
    def newWire(b: Boolean) = {
    val x = new Wire
    x.setSignal(b)
    x

  }
  
  def pow(n: Int, power: Int): Int = {
    if (power == 0) 1 else if (power == 1) n else
      n * pow(n, power - 1)
  }
  def makeTestWire(length: Int, n: Int): List[Wire] = {
    if (length == 1) {
      if (n == 0) List(newWire(false)) else
        List(newWire(true))

    } else {
      val power = pow(2, length-1)
      println("compare " + n + " to " + power)
      val test = n >= power
      val nextN = if (test) n - power else n
      newWire(test) :: makeTestWire(length - 1, nextN)
    }
  }
  
  makeTestWire(3,0)
  def runDemuxTest(n: Int) = {
    val inWire = newWire(true)
    val outWires = makeTestWire(pow(2, n), 0)
    for (a <- 0 to pow(2, n) - 1) yield {
      val controls = makeTestWire(n, a)
      demux(inWire, controls, outWires)
      run
      outWires
    }
  }
           runDemuxTest(3)
  
}