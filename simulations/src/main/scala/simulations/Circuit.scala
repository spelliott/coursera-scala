package simulations

import common._
import org.scalatest.FlatSpec

class Wire {
  private var sigVal = false
  private var actions: List[Simulator#Action] = List()

  def getSignal: Boolean = sigVal

  def setSignal(s: Boolean) {
    if (s != sigVal) {
      sigVal = s
      actions.foreach(action => action())
    }
  }

  def addAction(a: Simulator#Action) {
    actions = a :: actions
    a()
  }

  override def toString() = {
    "Wire:" + sigVal
  }
}

abstract class CircuitSimulator extends Simulator {

  val InverterDelay: Int
  val AndGateDelay: Int
  val OrGateDelay: Int

  def probe(name: String, wire: Wire) {
    wire addAction {
      () =>
        afterDelay(0) {
          println(
            "  " + currentTime + ": " + name + " -> " + wire.getSignal)
        }
    }
  }

  def inverter(input: Wire, output: Wire) {
    def invertAction() {
      val inputSig = input.getSignal
      afterDelay(InverterDelay) { output.setSignal(!inputSig) }
    }
    input addAction invertAction
  }

  def andGate(a1: Wire, a2: Wire, output: Wire) {
    def andAction() {
      val a1Sig = a1.getSignal
      val a2Sig = a2.getSignal
      afterDelay(AndGateDelay) { output.setSignal(a1Sig & a2Sig) }
    }
    a1 addAction andAction
    a2 addAction andAction
  }

  //
  // to complete with orGates and demux...
  //

  def orGate(a1: Wire, a2: Wire, output: Wire) {
    def orAction() {
      val a1Sig = a1.getSignal
      val a2Sig = a2.getSignal
      afterDelay(OrGateDelay) { output.setSignal(a1Sig | a2Sig) }
    }
    a1 addAction orAction
    a2 addAction orAction
  }

  def orGate2(a1: Wire, a2: Wire, output: Wire) {
    val w1, w2, w3 = new Wire()

    inverter(a1, w1)
    inverter(a2, w2)
    andGate(w1, w2, w3)
    inverter(w3, output)

  }

  def demux(in: Wire, c: List[Wire], out: List[Wire]) {
    c match {
      case List() => {
        val foo = new Wire
        inverter(in, foo)
        inverter(foo, out.head)
      }
      case cw :: xs => {
        val lhIn, rhIn, w1 = new Wire()
        inverter(cw, w1)
        andGate(in, cw, lhIn)

        andGate(in, w1, rhIn)
        val size = out.size
        val halfSize = size / 2
        demux(lhIn, xs, out.take(halfSize))
        demux(rhIn, xs, out.drop(halfSize))
      }
    }
  }

}

object Circuit extends CircuitSimulator {
  val InverterDelay = 1
  val AndGateDelay = 3
  val OrGateDelay = 5

  def andGateExample {
    val in1, in2, out = new Wire
    andGate(in1, in2, out)
    probe("in1", in1)
    probe("in2", in2)
    probe("out", out)
    in1.setSignal(false)
    in2.setSignal(false)
    run

    in1.setSignal(true)
    run

    in2.setSignal(true)
    run
  }

}

object CircuitMain extends App {
  // You can write tests either here, or better in the test class CircuitSuite.
  Circuit.andGateExample
}

