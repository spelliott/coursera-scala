package week1


object funs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(39); 
val x = 1


  trait Generator[+T] {
    self =>
    def generate: T
    def foreach[U](f: T => U) {
      f(generate)
    }
    def map[S](f: T => S): Generator[S] = new Generator[S] {
      def generate = f(self.generate)
    }
    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      def generate = f(self.generate).generate
    }
  };System.out.println("""x  : Int = """ + $show(x ));$skip(442); 

  val integers = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  };System.out.println("""integers  : week1.funs.Generator[Int] = """ + $show(integers ));$skip(40); 
  
 val booleans = integers.map(_ >= 0);System.out.println("""booleans  : week1.funs.Generator[Boolean] = """ + $show(booleans ));$skip(31); val res$0 = 
 
 for (x <- integers) yield x;System.out.println("""res0: week1.funs.Generator[Int] = """ + $show(res$0));$skip(23); val res$1 = 
  
  integers.generate;System.out.println("""res1: Int = """ + $show(res$1))}
  
  
 
}
