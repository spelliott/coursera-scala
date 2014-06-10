package funsets

import FunSets._
object FunSetsWorksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  var a = 4                                       //> a  : Int = 4
  singletonSet(1)                                 //> res0: Int => Boolean = <function1>
  def evens = (x: Int) => x % 2 == 0              //> evens: => Int => Boolean
  contains(evens,2)                               //> res1: Boolean = true
  contains(evens,1)                               //> res2: Boolean = false
  var evensAndOne = union(evens,singletonSet(1))  //> evensAndOne  : Int => Boolean = <function1>
  contains(evensAndOne,3)                         //> res3: Boolean = false
  var nowt = intersect(evens,singletonSet(1))     //> nowt  : Int => Boolean = <function1>
  contains(nowt,10)                               //> res4: Boolean = false
  var evensAndThree = filter(evens, x => x % 3 == 0)
                                                  //> evensAndThree  : Int => Boolean = <function1>
  contains(evensAndThree,6)                       //> res5: Boolean = true
  
  var squaresOfEvens = map(evens,x => x * x)      //> squaresOfEvens  : Int => Boolean = <function1>
  contains(squaresOfEvens,2)                      //> res6: Boolean = true
  
}