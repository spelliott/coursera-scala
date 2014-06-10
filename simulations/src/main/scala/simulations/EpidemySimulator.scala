package simulations

import math.random

class EpidemySimulator extends Simulator {

  def randomBelow(i: Int) = (random * i).toInt

  protected[simulations] object SimConfig {
    val population: Int = 300
    val roomRows: Int = 8
    val roomColumns: Int = 8

    // to complete: additional parameters of simulation
  }

  import SimConfig._

  val persons: List[Person] = List() // to complete: construct list of persons

  class Person(val id: Int) {
    var infected = false
    var sick = false
    var immune = false
    var dead = false

    // demonstrates random number generation
    var row: Int = randomBelow(roomRows)
    var col: Int = randomBelow(roomColumns)

    //
    // to complete with simulation logic
    //

    def move() {
      // do nothing if dead

      // stuff
      // for each of 4 neighbouring rooms (random order)
      // if don't contain visibly infectious people
      // move to that room
      // else don't move

      // if there is an infected person in the room
      // and i am not infected and not immune
      // get infected according to trans rate

      afterDelay(randomBelow(6))(move)
    }

    def die() {
      dead = true
    }

    def getInfected() {
      infected = true
      afterDelay(6)(becomeVisiblyInfectious)
      val dieIfZero = randomBelow(4)
      if (dieIfZero == 0) {
        afterDelay(14)(die)
      } else {
        afterDelay(16)(loseVisiblyInfectious)
        afterDelay(18)(cured)
      }

    }

    def becomeVisiblyInfectious() {
      sick = true
    }

    def loseVisiblyInfectious() {
      sick = false
      immune = true
    }

    def cured() {
      infected = false
      immune = false
    }
  }
}
