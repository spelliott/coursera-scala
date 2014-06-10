package objsets

object other {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  println("Welcome to the Scala worksheet");$skip(247); 
  
  def flatten(x: List[Any]): List[Any] = { x match {
   case List() => x
   case head :: tail => head match {
   	case headHead :: headTail => headHead :: flatten(headTail) ++ flatten(tail)
   	case _ => head :: flatten(tail)
   }
    
  }
  };System.out.println("""flatten: (x: List[Any])List[Any]""");$skip(21); val res$0 = 
  
  flatten(List());System.out.println("""res0: List[Any] = """ + $show(res$0));$skip(45); val res$1 = 
  flatten(List(List(1,2),3,List(4,List(5))));System.out.println("""res1: List[Any] = """ + $show(res$1));$skip(268); 
 
 def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs,ys) match {
 case (List(),List()) => List()
 case (a,List()) => a
 case (List(),b) => b
 case (xHead :: xTail,yHead :: yTail) => if (xHead < yHead) xHead :: merge(xTail,ys) else yHead :: merge(xs,yTail)
 
 };System.out.println("""merge: (xs: List[Int], ys: List[Int])List[Int]""");$skip(34); val res$2 = 
 
 merge(List(1,3,5),List(2,4,6));System.out.println("""res2: List[Int] = """ + $show(res$2))}
 
}
