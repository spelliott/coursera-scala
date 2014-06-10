package quickcheck
import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._
import quickcheck._

object ws1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(166); 
  println("Welcome to the Scala worksheet");$skip(53); 
  val correct = new QuickCheckHeap with BinomialHeap;System.out.println("""correct  : quickcheck.QuickCheckHeap with quickcheck.BinomialHeap = """ + $show(correct ));$skip(58); 
  val wrong1 = new QuickCheckHeap with Bogus1BinomialHeap;System.out.println("""wrong1  : quickcheck.QuickCheckHeap with quickcheck.Bogus1BinomialHeap = """ + $show(wrong1 ));$skip(58); 
  val wrong2 = new QuickCheckHeap with Bogus2BinomialHeap;System.out.println("""wrong2  : quickcheck.QuickCheckHeap with quickcheck.Bogus2BinomialHeap = """ + $show(wrong2 ));$skip(58); 
  val wrong3 = new QuickCheckHeap with Bogus3BinomialHeap;System.out.println("""wrong3  : quickcheck.QuickCheckHeap with quickcheck.Bogus3BinomialHeap = """ + $show(wrong3 ));$skip(58); 
  val wrong4 = new QuickCheckHeap with Bogus4BinomialHeap;System.out.println("""wrong4  : quickcheck.QuickCheckHeap with quickcheck.Bogus4BinomialHeap = """ + $show(wrong4 ));$skip(58); 
  val wrong5 = new QuickCheckHeap with Bogus5BinomialHeap;System.out.println("""wrong5  : quickcheck.QuickCheckHeap with quickcheck.Bogus5BinomialHeap = """ + $show(wrong5 ));$skip(69); val res$0 = 
  
  
  correct.isDescending(List(2147483647, 888878498, 888878498));System.out.println("""res0: Boolean = """ + $show(res$0));$skip(39); val res$1 = 
  
  correct.isDescending(List(2,1,1));System.out.println("""res1: Boolean = """ + $show(res$1));$skip(35); val res$2 = 
  correct.listMin(List(3,6,8,1,0));System.out.println("""res2: quickcheck.ws1.correct.A = """ + $show(res$2));$skip(16); 

 correct.check;$skip(16); 
 
 wrong1.check;$skip(16); 
 
 wrong2.check;$skip(16); 
 
 wrong3.check;$skip(16); 
 
 wrong4.check;$skip(16); 
 
 wrong5.check}
 

 
 
 
 
}
