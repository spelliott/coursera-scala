package quickcheck
import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._
import quickcheck._

object ws1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val correct = new QuickCheckHeap with BinomialHeap
                                                  //> correct  : quickcheck.QuickCheckHeap with quickcheck.BinomialHeap = Prop
  val wrong1 = new QuickCheckHeap with Bogus1BinomialHeap
                                                  //> wrong1  : quickcheck.QuickCheckHeap with quickcheck.Bogus1BinomialHeap = Pro
                                                  //| p
  val wrong2 = new QuickCheckHeap with Bogus2BinomialHeap
                                                  //> wrong2  : quickcheck.QuickCheckHeap with quickcheck.Bogus2BinomialHeap = Pro
                                                  //| p
  val wrong3 = new QuickCheckHeap with Bogus3BinomialHeap
                                                  //> wrong3  : quickcheck.QuickCheckHeap with quickcheck.Bogus3BinomialHeap = Pro
                                                  //| p
  val wrong4 = new QuickCheckHeap with Bogus4BinomialHeap
                                                  //> wrong4  : quickcheck.QuickCheckHeap with quickcheck.Bogus4BinomialHeap = Pro
                                                  //| p
  val wrong5 = new QuickCheckHeap with Bogus5BinomialHeap
                                                  //> wrong5  : quickcheck.QuickCheckHeap with quickcheck.Bogus5BinomialHeap = Pro
                                                  //| p
  
  
  correct.isDescending(List(2147483647, 888878498, 888878498))
                                                  //> res0: Boolean = true
  
  correct.isDescending(List(2,1,1))               //> res1: Boolean = true
  correct.listMin(List(3,6,8,1,0))                //> res2: quickcheck.ws1.correct.A = 0

 correct.check                                    //> + BinomialHeap.min1: OK, passed 100 tests.
                                                  //| + BinomialHeap.empty: OK, passed 100 tests.
                                                  //| + BinomialHeap.min2: OK, passed 100 tests.
                                                  //| + BinomialHeap.in-is-out: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending2: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending3: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending4: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending5: OK, passed 100 tests.
                                                  //| + BinomialHeap.insert-and-delete: OK, passed 100 tests.
                                                  //| + BinomialHeap.meld: OK, passed 100 tests.
                                                  //| + BinomialHeap.meld2: OK, passed 100 tests.
                                                  //| + BinomialHeap.many-insert: OK, passed 100 tests.
                                                  //| + BinomialHeap.size: OK, passed 100 tests.
                                                  //| + BinomialHeap.size2: OK, passed 100 tests.
 
 wrong1.check                                     //> + BinomialHeap.min1: OK, passed 100 tests.
                                                  //| + BinomialHeap.empty: OK, passed 100 tests.
                                                  //| + BinomialHeap.min2: OK, passed 100 tests.
                                                  //| ! BinomialHeap.in-is-out: Falsified after 5 passed tests.
                                                  //| > ARG_0: List("0", "0", "1")
                                                  //| ! BinomialHeap.descending: Falsified after 5 passed tests.
                                                  //| > ARG_0: List(Node(1371005224,0,List()), Node(-386977161,1,List(Node(-1,0,L
                                                  //|   ist()))))
                                                  //| ! BinomialHeap.descending2: Falsified after 40 passed tests.
                                                  //| > ARG_0: List(Node(-2147483648,3,List(Node(-2147483648,2,List(Node(14765015
                                                  //|   33,1,List(Node(1931367666,0,List()))), Node(-1482002408,0,List()))), Node
                                                  //|   (-1242821513,1,List(Node(1976112030,0,List()))), Node(-1,0,List()))))
                                                  //| ! BinomialHeap.descending3: Falsified after 1 passed tests.
                                                  //| > ARG_0: List(Node(1951658565,0,List()))
                                                  //| > ARG_1: List(Node(0,0,List()), Node(-874688433,1,List(Node(-394447794,0,Li
                                                  //|   st()))), Node(-1573647699,2,List(Node(-1,1,List(Node(0,0,List()))), Node(
                                                  //|   1186994986,0,List()))
                                                  //| Output exceeds cutoff limit.
 
 wrong2.check                                     //> + BinomialHeap.min1: OK, passed 100 tests.
                                                  //| + BinomialHeap.empty: OK, passed 100 tests.
                                                  //| ! BinomialHeap.min2: Falsified after 0 passed tests.
                                                  //| > ARG_0: 0
                                                  //| > ARG_1: -1
                                                  //| ! BinomialHeap.in-is-out: Falsified after 4 passed tests.
                                                  //| > ARG_0: List("0", "1")
                                                  //| ! BinomialHeap.descending: Falsified after 1 passed tests.
                                                  //| > ARG_0: List(Node(1154368371,0,List()), Node(2147483647,2,List(Node(214748
                                                  //|   3647,1,List(Node(-2147483648,0,List()))), Node(-453597565,0,List()))))
                                                  //| ! BinomialHeap.descending2: Falsified after 5 passed tests.
                                                  //| > ARG_0: List(Node(1939292858,0,List()), Node(585015447,1,List(Node(-195230
                                                  //|   3984,0,List()))))
                                                  //| ! BinomialHeap.descending3: Falsified after 0 passed tests.
                                                  //| > ARG_0: List(Node(1,0,List()), Node(581234534,1,List(Node(317981684,0,List
                                                  //|   ()))))
                                                  //| > ARG_1: List(Node(2147483647,2,List(Node(1050629731,1,List(Node(-142524092
                                                  //|   0,0,List()))), Node(2061120417,0,List()))))
                                                  //| ! BinomialHeap.descending4: Falsified af
                                                  //| Output exceeds cutoff limit.
 
 wrong3.check                                     //> + BinomialHeap.min1: OK, passed 100 tests.
                                                  //| + BinomialHeap.empty: OK, passed 100 tests.
                                                  //| + BinomialHeap.min2: OK, passed 100 tests.
                                                  //| ! BinomialHeap.in-is-out: Falsified after 6 passed tests.
                                                  //| > ARG_0: List("0", "1")
                                                  //| + BinomialHeap.descending: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending2: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending3: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending4: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending5: OK, passed 100 tests.
                                                  //| + BinomialHeap.insert-and-delete: OK, passed 100 tests.
                                                  //| + BinomialHeap.meld: OK, passed 100 tests.
                                                  //| + BinomialHeap.meld2: OK, passed 100 tests.
                                                  //| + BinomialHeap.many-insert: OK, passed 100 tests.
                                                  //| + BinomialHeap.size: OK, passed 100 tests.
                                                  //| + BinomialHeap.size2: OK, passed 100 tests.
 
 wrong4.check                                     //> + BinomialHeap.min1: OK, passed 100 tests.
                                                  //| + BinomialHeap.empty: OK, passed 100 tests.
                                                  //| + BinomialHeap.min2: OK, passed 100 tests.
                                                  //| ! BinomialHeap.in-is-out: Falsified after 5 passed tests.
                                                  //| > ARG_0: List("0", "0", "1")
                                                  //| + BinomialHeap.descending: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending2: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending3: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending4: OK, passed 100 tests.
                                                  //| + BinomialHeap.descending5: OK, passed 100 tests.
                                                  //| + BinomialHeap.insert-and-delete: OK, passed 100 tests.
                                                  //| + BinomialHeap.meld: OK, passed 100 tests.
                                                  //| + BinomialHeap.meld2: OK, passed 100 tests.
                                                  //| + BinomialHeap.many-insert: OK, passed 100 tests.
                                                  //| + BinomialHeap.size: OK, passed 100 tests.
                                                  //| + BinomialHeap.size2: OK, passed 100 tests.
 
 wrong5.check                                     //> + BinomialHeap.min1: OK, passed 100 tests.
                                                  //| + BinomialHeap.empty: OK, passed 100 tests.
                                                  //| + BinomialHeap.min2: OK, passed 100 tests.
                                                  //| ! BinomialHeap.in-is-out: Falsified after 5 passed tests.
                                                  //| > ARG_0: List("-2", "0", "-1")
                                                  //| ! BinomialHeap.descending: Falsified after 3 passed tests.
                                                  //| > ARG_0: List(Node(-1,1,List(Node(2147483647,0,List()))), Node(-1,2,List(No
                                                  //|   de(0,1,List(Node(2147483647,0,List()))), Node(1279408782,0,List()))))
                                                  //| ! BinomialHeap.descending2: Falsified after 3 passed tests.
                                                  //| > ARG_0: List(Node(-2092017539,3,List(Node(-632870027,2,List(Node(-1,1,List
                                                  //|   (Node(256531252,0,List()))), Node(2147483647,0,List()))), Node(-158432814
                                                  //|   7,1,List(Node(-20663285,0,List()))), Node(1314712800,0,List()))))
                                                  //| ! BinomialHeap.descending3: Falsified after 0 passed tests.
                                                  //| > ARG_0: List(Node(0,1,List(Node(2147483647,0,List()))))
                                                  //| > ARG_1: List(Node(-2100312669,1,List(Node(1623377892,0,List()))))
                                                  //| ! BinomialHeap.descending4: Falsified 
                                                  //| Output exceeds cutoff limit.
 

 
 
 
 
}