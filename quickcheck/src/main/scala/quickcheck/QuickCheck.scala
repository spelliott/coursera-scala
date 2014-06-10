package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("BinomialHeap") with IntHeap {

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("empty") = forAll { (h: H) =>
    //    collect(size(h)) {
    isEmpty(empty)
    //    }

  }

  property("min2") = forAll { (a: Int, b: Int) =>
    val withOne = insert(a, empty)
    val withTwo = insert(b, withOne)
    val theMin = if (a < b) a else b
    findMin(withTwo) == theMin
  }

  property("in-is-out") = forAll { (l: List[Int]) =>
    val sortedList = l.sorted.reverse
    sortedList == getSeq(insertAll(l, empty))
  }
  property("descending") = forAll { (h: H) =>
    {
      //      println(getSeq(h))
      isDescending(getSeq(h))
    }

  }

  property("descending2") = forAll { (h: H) =>
    isDescending(getSeq(deleteMin(h)))

  }

  property("descending3") = forAll { (h1: H, h2: H) =>
    isDescending(getSeq(meld(h1, h2)))

  }

  property("descending4") = forAll { (l: List[Int]) =>
    isDescending(getSeq(insertAll(l, empty)))

  }

  property("descending5") = forAll { (l: List[Int], h: H) =>
    isDescending(getSeq(insertAll(l, h)))

  }

  property("insert-and-delete") = forAll { (a: Int) =>
    isEmpty(deleteMin(insert(a, empty)))
  }

  property("meld") = forAll { (h1: H, h2: H) =>
    val min1 = findMin(h1)
    val min2 = findMin(h2)
    val minmin = if (min1 < min2) min1 else min2
    findMin(meld(h1, h2)) == minmin
  }

  property("meld2") = forAll { (i1: H, i2: H) =>
    if (size(i1) < 2 || size(i2) < 2) true else {
      val h1 = deleteMin(i1)
      val h2 = deleteMin(i2)
      val min1 = findMin(h1)
      val min2 = findMin(h2)
      val minmin = if (min1 < min2) min1 else min2
      findMin(meld(h1, h2)) == minmin
    }
  }

  property("many-insert") = forAll { (l: List[A]) =>
    l match {
      case List() => true
      case x :: xs => findMin(insertAll(l, empty)) == listMin(l)
    }
  }

  property("size") = forAll { (h1: H, h2: H) =>
    size(meld(h1, h2)) == size(h1) + size(h2)

  }

  property("size2") = forAll { (h: H, l: List[Int]) =>
    size(meld(h, insertAll(l, empty))) == size(h) + l.size

  }

  def size(h: H) = sizeAux(h, 0)

  def sizeAux(h: H, n: Integer): Integer =
    if (isEmpty(h)) n else sizeAux(deleteMin(h), n + 1)

  def getSeq(h: H) = getSeqAux(h, List())

  def getSeqAux(h: H, s: List[Int]): List[Int] = if (isEmpty(h)) s else {
    val theMin = findMin(h)
    getSeqAux(deleteMin(h), theMin :: s)
  }

  def isDescending(l: List[Int]): Boolean = l match {
    case List() => true
    case List(el1) => true
    case el1 :: List(el2) => el1 >= el2
    case el1 :: el2 :: more => el1 >= el2 && isDescending(l.tail)
  }

  def insertAll(l: List[A], h: H): H = l match {
    case List() => h
    case x :: xs => insertAll(xs, insert(x, h))
  }

  def listMin(l: List[A]): A = l match {
    case List() => throw new NoSuchElementException("empty list min")
    case List(x) => x
    case x :: List(x2) => if (x < x2) x else x2
    case x :: x2 :: rest => if (x < x2) listMin(x :: rest) else listMin(x2 :: rest)

  }
  //  lazy val genHeap: Gen[H] = ???

  //  val x = new BinomialHeap with IntHeap

  lazy val genHeap: Gen[H] = for {
    i <- arbitrary[Int]
    h <- oneOf(value(empty), genHeap)

  } yield insert(i, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

}
