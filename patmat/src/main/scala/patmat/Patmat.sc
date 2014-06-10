package patmat
//import common._
//import patmat._
//import Huffman._
object Patmat {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  "abccc".groupBy(x => x)                         //> res0: scala.collection.immutable.Map[Char,String] = Map(b -> b, a -> a, c ->
                                                  //|  ccc)
  "abccc".groupBy(x => x).map(x => 1)             //> res1: scala.collection.immutable.Iterable[Int] = List(1, 1, 1)
  "abccc".groupBy(x => x).map(x => (x._1,x._2.length))
                                                  //> res2: scala.collection.immutable.Map[Char,Int] = Map(b -> 1, a -> 1, c -> 3)
                                                  //| 
                   def times(chars: List[Char]): List[(Char, Int)] = chars.groupBy(x => x).map(x => (x._1, x._2.length)).toList
                                                  //> times: (chars: List[Char])List[(Char, Int)]
                   times('g' :: List('o'))        //> res3: List[(Char, Int)] = List((g,1), (o,1))
                   
                   Huffman.decodedSecret          //> res4: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
                   Huffman.encode(Huffman.frenchCode)(List('a','b','c'))
                                                  //> res5: List[patmat.Huffman.Bit] = List(1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0,
                                                  //|  0, 1, 0)
                   Huffman.decode(Huffman.frenchCode,    List(1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0))
                                                  //> res6: List[Char] = List(a, b, c)
                   Huffman.quickEncode(Huffman.frenchCode)(List('a','b','c'))
                                                  //> res7: List[patmat.Huffman.Bit] = List(1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0,
                                                  //|  0, 1, 0)
                   Huffman.convert(Huffman.frenchCode)
                                                  //> res8: patmat.Huffman.CodeTable = List((s,List(0, 0, 0)), (d,List(0, 0, 1, 0)
                                                  //| ), (x,List(0, 0, 1, 1, 0, 0, 0)), (j,List(0, 0, 1, 1, 0, 0, 1)), (f,List(0, 
                                                  //| 0, 1, 1, 0, 1)), (z,List(0, 0, 1, 1, 1, 0, 0, 0, 0)), (k,List(0, 0, 1, 1, 1,
                                                  //|  0, 0, 0, 1, 0)), (w,List(0, 0, 1, 1, 1, 0, 0, 0, 1, 1)), (y,List(0, 0, 1, 1
                                                  //| , 1, 0, 0, 1)), (h,List(0, 0, 1, 1, 1, 0, 1)), (q,List(0, 0, 1, 1, 1, 1)), (
                                                  //| o,List(0, 1, 0, 0)), (l,List(0, 1, 0, 1)), (m,List(0, 1, 1, 0, 0)), (p,List(
                                                  //| 0, 1, 1, 0, 1)), (u,List(0, 1, 1, 1)), (r,List(1, 0, 0, 0)), (c,List(1, 0, 0
                                                  //| , 1, 0)), (v,List(1, 0, 0, 1, 1, 0)), (g,List(1, 0, 0, 1, 1, 1, 0)), (b,List
                                                  //| (1, 0, 0, 1, 1, 1, 1)), (n,List(1, 0, 1, 0)), (t,List(1, 0, 1, 1)), (e,List(
                                                  //| 1, 1, 0)), (i,List(1, 1, 1, 0)), (a,List(1, 1, 1, 1)))
                   Huffman.encode(Huffman.frenchCode)(List('s'))
                                                  //> res9: List[patmat.Huffman.Bit] = List(0, 0, 0)
                                                 
                   val table1 = List(('a',Huffman.encode(Huffman.frenchCode)(List('a'))))
                                                  //> table1  : List[(Char, List[patmat.Huffman.Bit])] = List((a,List(1, 1, 1, 1)
                                                  //| ))
                   val table2 = List(('b',Huffman.encode(Huffman.frenchCode)(List('b'))))
                                                  //> table2  : List[(Char, List[patmat.Huffman.Bit])] = List((b,List(1, 0, 0, 1,
                                                  //|  1, 1, 1)))
                   Huffman.mergeCodeTables(table1,table2)
                                                  //> res10: patmat.Huffman.CodeTable = List((a,List(1, 1, 1, 1)), (b,List(1, 0, 
                                                  //| 0, 1, 1, 1, 1)))
                   val simpleTree = Huffman.Leaf('a',5)
                                                  //> simpleTree  : patmat.Huffman.Leaf = Leaf(a,5)
                   Huffman.convert(simpleTree)    //> res11: patmat.Huffman.CodeTable = List((a,List()))
                   Huffman.encode(simpleTree)(List('a'))
                                                  //> res12: List[patmat.Huffman.Bit] = List()
                                                
}