package funsets

import FunSets._
object FunSetsWorksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(103); 
  println("Welcome to the Scala worksheet");$skip(12); 
  var a = 4;System.out.println("""a  : Int = """ + $show(a ));$skip(18); val res$0 = 
  singletonSet(1);System.out.println("""res0: Int => Boolean = """ + $show(res$0));$skip(37); 
  def evens = (x: Int) => x % 2 == 0;System.out.println("""evens: => Int => Boolean""");$skip(20); val res$1 = 
  contains(evens,2);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(20); val res$2 = 
  contains(evens,1);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(49); 
  var evensAndOne = union(evens,singletonSet(1));System.out.println("""evensAndOne  : Int => Boolean = """ + $show(evensAndOne ));$skip(26); val res$3 = 
  contains(evensAndOne,3);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(46); 
  var nowt = intersect(evens,singletonSet(1));System.out.println("""nowt  : Int => Boolean = """ + $show(nowt ));$skip(20); val res$4 = 
  contains(nowt,10);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(53); 
  var evensAndThree = filter(evens, x => x % 3 == 0);System.out.println("""evensAndThree  : Int => Boolean = """ + $show(evensAndThree ));$skip(28); val res$5 = 
  contains(evensAndThree,6);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(48); 
  
  var squaresOfEvens = map(evens,x => x * x);System.out.println("""squaresOfEvens  : Int => Boolean = """ + $show(squaresOfEvens ));$skip(29); val res$6 = 
  contains(squaresOfEvens,2);System.out.println("""res6: Boolean = """ + $show(res$6))}
  
}
