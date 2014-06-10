package week1


object funs {
val x = 1                                         //> x  : Int = 1


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
  }

  val integers = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  }                                               //> integers  : week1.funs.Generator[Int] = week1.funs$$anonfun$main$1$$anon$3@3
                                                  //| a805550
  
 val booleans = integers.map(_ >= 0)              //> booleans  : week1.funs.Generator[Boolean] = week1.funs$$anonfun$main$1$Gener
                                                  //| ator$1$$anon$1@af094f2
 
 for (x <- integers) yield x                      //> res0: week1.funs.Generator[Int] = week1.funs$$anonfun$main$1$Generator$1$$an
                                                  //| on$1@25644679
  
  integers.generate                               //> res1: Int = -934059969
  
  
 
}