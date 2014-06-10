package patmat
//import common._
//import patmat._
//import Huffman._
object Patmat {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(129); 
  println("Welcome to the Scala worksheet");$skip(26); val res$0 = 
  "abccc".groupBy(x => x);System.out.println("""res0: scala.collection.immutable.Map[Char,String] = """ + $show(res$0));$skip(38); val res$1 = 
  "abccc".groupBy(x => x).map(x => 1);System.out.println("""res1: scala.collection.immutable.Iterable[Int] = """ + $show(res$1));$skip(55); val res$2 = 
  "abccc".groupBy(x => x).map(x => (x._1,x._2.length));System.out.println("""res2: scala.collection.immutable.Map[Char,Int] = """ + $show(res$2));$skip(128); 
                   def times(chars: List[Char]): List[(Char, Int)] = chars.groupBy(x => x).map(x => (x._1, x._2.length)).toList;System.out.println("""times: (chars: List[Char])List[(Char, Int)]""");$skip(43); val res$3 = 
                   times('g' :: List('o'));System.out.println("""res3: List[(Char, Int)] = """ + $show(res$3));$skip(61); val res$4 = 
                   
                   Huffman.decodedSecret;System.out.println("""res4: List[Char] = """ + $show(res$4));$skip(73); val res$5 = 
                   Huffman.encode(Huffman.frenchCode)(List('a','b','c'));System.out.println("""res5: List[patmat.Huffman.Bit] = """ + $show(res$5));$skip(111); val res$6 = 
                   Huffman.decode(Huffman.frenchCode,    List(1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0));System.out.println("""res6: List[Char] = """ + $show(res$6));$skip(78); val res$7 = 
                   Huffman.quickEncode(Huffman.frenchCode)(List('a','b','c'));System.out.println("""res7: List[patmat.Huffman.Bit] = """ + $show(res$7));$skip(55); val res$8 = 
                   Huffman.convert(Huffman.frenchCode);System.out.println("""res8: patmat.Huffman.CodeTable = """ + $show(res$8));$skip(65); val res$9 = 
                   Huffman.encode(Huffman.frenchCode)(List('s'));System.out.println("""res9: List[patmat.Huffman.Bit] = """ + $show(res$9));$skip(140); 
                                                 
                   val table1 = List(('a',Huffman.encode(Huffman.frenchCode)(List('a'))));System.out.println("""table1  : List[(Char, List[patmat.Huffman.Bit])] = """ + $show(table1 ));$skip(90); 
                   val table2 = List(('b',Huffman.encode(Huffman.frenchCode)(List('b'))));System.out.println("""table2  : List[(Char, List[patmat.Huffman.Bit])] = """ + $show(table2 ));$skip(58); val res$10 = 
                   Huffman.mergeCodeTables(table1,table2);System.out.println("""res10: patmat.Huffman.CodeTable = """ + $show(res$10));$skip(56); 
                   val simpleTree = Huffman.Leaf('a',5);System.out.println("""simpleTree  : patmat.Huffman.Leaf = """ + $show(simpleTree ));$skip(47); val res$11 = 
                   Huffman.convert(simpleTree);System.out.println("""res11: patmat.Huffman.CodeTable = """ + $show(res$11));$skip(57); val res$12 = 
                   Huffman.encode(simpleTree)(List('a'));System.out.println("""res12: List[patmat.Huffman.Bit] = """ + $show(res$12))}
                                                
}
