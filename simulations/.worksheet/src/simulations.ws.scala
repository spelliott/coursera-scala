package simulations
import common._
import org.scalatest.FlatSpec

object ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(122); 
  println("Welcome to the Scala worksheet");$skip(60); val res$0 = 
  
  List(1)  match {
  case x :: xs => 1
  case _ => 0
  };System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
  
  1 :: List();System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(21); 
  
 val w = new Wire;System.out.println("""w  : simulations.Wire = """ + $show(w ));$skip(109); 
 
  def makeWires(n: Int): List[Wire] = {
    if (n == 0) List() else
      new Wire :: makeWires(n - 1)
  };System.out.println("""makeWires: (n: Int)List[simulations.Wire]""");$skip(18); val res$2 = 
  
  makeWires(5);System.out.println("""res2: List[simulations.Wire] = """ + $show(res$2));$skip(86); 
  
    def newWire(b: Boolean) = {
    val x = new Wire
    x.setSignal(b)
    x

  };System.out.println("""newWire: (b: Boolean)simulations.Wire""");$skip(124); 
  
  def pow(n: Int, power: Int): Int = {
    if (power == 0) 1 else if (power == 1) n else
      n * pow(n, power - 1)
  };System.out.println("""pow: (n: Int, power: Int)Int""");$skip(385); 
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
  };System.out.println("""makeTestWire: (length: Int, n: Int)List[simulations.Wire]""");$skip(23); val res$3 = 
  
  makeTestWire(3,0);System.out.println("""res3: List[simulations.Wire] = """ + $show(res$3));$skip(265); 
  def runDemuxTest(n: Int) = {
    val inWire = newWire(true)
    val outWires = makeTestWire(pow(2, n), 0)
    for (a <- 0 to pow(2, n) - 1) yield {
      val controls = makeTestWire(n, a)
      demux(inWire, controls, outWires)
      run
      outWires
    }
  };System.out.println("""runDemuxTest: (n: Int)scala.collection.immutable.IndexedSeq[List[simulations.Wire]]""");$skip(27); val res$4 = 
           runDemuxTest(3);System.out.println("""res4: scala.collection.immutable.IndexedSeq[List[simulations.Wire]] = """ + $show(res$4))}
  
}
