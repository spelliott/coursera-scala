package objsets

object other {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def flatten(x: List[Any]): List[Any] = { x match {
   case List() => x
   case head :: tail => head match {
   	case headHead :: headTail => headHead :: flatten(headTail) ++ flatten(tail)
   	case _ => head :: flatten(tail)
   }
    
  }
  }                                               //> flatten: (x: List[Any])List[Any]
  
  flatten(List())                                 //> res0: List[Any] = List()
  flatten(List(List(1,2),3,List(4,List(5))))      //> res1: List[Any] = List(1, 2, 3, 4, 5)
 
 def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs,ys) match {
 case (List(),List()) => List()
 case (a,List()) => a
 case (List(),b) => b
 case (xHead :: xTail,yHead :: yTail) => if (xHead < yHead) xHead :: merge(xTail,ys) else yHead :: merge(xs,yTail)
 
 }                                                //> merge: (xs: List[Int], ys: List[Int])List[Int]
 
 merge(List(1,3,5),List(2,4,6))                   //> res2: List[Int] = List(1, 2, 3, 4, 5, 6)
 
}