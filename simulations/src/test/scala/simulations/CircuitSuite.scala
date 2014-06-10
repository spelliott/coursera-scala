package simulations

import org.scalatest.FunSuite
import scala.math
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CircuitSuite extends CircuitSimulator with FunSuite {
  val InverterDelay = 1
  val AndGateDelay = 3
  val OrGateDelay = 5

  test("andGate example") {
    val in1, in2, out = new Wire
    andGate(in1, in2, out)
    in1.setSignal(false)
    in2.setSignal(false)
    run

    assert(out.getSignal === false, "and 1")

    in1.setSignal(true)
    run

    assert(out.getSignal === false, "and 2")

    in2.setSignal(true)
    run

    assert(out.getSignal === true, "and 3")
  }

  def orTest(doTheOrGate: (Wire, Wire, Wire) => Unit, desc: String) =

    test("orGate example: " + desc) {
      val in1, in2, out = new Wire
      //orGate(in1, in2, out)
      doTheOrGate(in1, in2, out)
      in1.setSignal(false)
      in2.setSignal(false)
      run
      assert(out.getSignal === false, "0 and 0 -> 0")

      in1.setSignal(true)
      run
      assert(out.getSignal === true, "1 and 0 -> 1")

      in1.setSignal(false)
      in2.setSignal(true)
      assert(out.getSignal === true, "0 and 1 -> 1")

      in1.setSignal(true)
      assert(out.getSignal === true, "1 and 1 -> 1")

    }

  orTest(orGate, "Native OR gate")

  orTest(orGate2, "OR gate from AND and INVERT")

  def makeWires(n: Int): List[Wire] = {
    if (n == 0) List() else
      new Wire :: makeWires(n - 1)
  }

  test("demux") {
    // one control, two outputs
    val control = makeWires(1)
    val outs = makeWires(2)
    val in = new Wire
    demux(in, control, outs)
    in.setSignal(false);
    control.head.setSignal(false);
    run
    val trueCount = outs.count(w => w.getSignal == true)
    val falseCount = outs.count(w => w.getSignal == false)

    assert(trueCount === 0)
    assert(falseCount === 2)
    control.head.setSignal(true)

    run

    val trueCount2 = outs.count(w => w.getSignal == true)
    val falseCount2 = outs.count(w => w.getSignal == false)

    assert(trueCount2 === 0)
    assert(falseCount2 === 2)

    in.setSignal(true)
    control.head.setSignal(false)
    run

    val trueCount3 = outs.count(w => w.getSignal == true)
    val falseCount3 = outs.count(w => w.getSignal == false)

    assert(trueCount3 === 1)
    assert(falseCount3 === 1)

    val wireOneState = outs.head.getSignal
    val wireTwoState = outs.last.getSignal
    control.head.setSignal(true)
    run

    val wireOneState2 = outs.head.getSignal
    val wireTwoState2 = outs.last.getSignal

    assert(wireOneState != wireOneState2)
    assert(wireTwoState != wireTwoState2)
  }

  //
  // to complete with tests for orGate, demux, ...
  //

  def newWire(b: Boolean) = {
    val x = new Wire
    x.setSignal(b)
    x

  }

  def pow(n: Int, power: Int): Int = {
    if (power < 0) throw new Exception("what?") else if (power == 0) 1 else if (power == 1) n else
      n * pow(n, power - 1)
  }
  def makeTestWire(length: Int, n: Int): List[Wire] = {
    if (length == 0) List() else if (length == 1) {
      if (n == 0) List(newWire(false)) else
        List(newWire(true))

    } else {
      val power = pow(2, length - 1)
      val test = n >= power
      val nextN = if (test) n - power else n
      newWire(test) :: makeTestWire(length - 1, nextN)
    }
  }

  def mergeBools(a: List[Boolean], b: List[Boolean]): List[Boolean] = {
    a match {
      case List() => a
      case x :: xs => if (a.head & b.head) (throw new Exception("two trues in same place!")) else
        (a.head | b.head) :: mergeBools(a.tail, b.tail)
    }
  }
  def runDemuxTest(n: Int) = {
    val inWire = newWire(true)

    for (a <- 0 to pow(2, n) - 1) yield {
      val outWires = makeTestWire(pow(2, n), 0)
      val controls = makeTestWire(n, a)
      demux(inWire, controls, outWires)
      run
      outWires
    }
  }

  def demuxTest(n: Integer) =
    test("demux size " + n) {
      val lists = runDemuxTest(n)
      val bools = lists.map(x => x.map(y => y.getSignal))
      val reducedBools = bools.reduce(mergeBools)
      val falseCount = reducedBools.count(x => x == false)
      assert(falseCount === 0)
    }

  for (a <- 0 to 6) yield demuxTest(a)
}
