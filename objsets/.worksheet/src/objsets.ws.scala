package objsets
import common._
import objsets._
import TweetData._
import TweetReader._
 
 
object ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(148); 
  println("Welcome to the Scala worksheet");$skip(32); 
  var t1 = new Tweet("1","1",1);System.out.println("""t1  : objsets.Tweet = """ + $show(t1 ));$skip(32); 
  var t2 = new Tweet("2","2",2);System.out.println("""t2  : objsets.Tweet = """ + $show(t2 ));$skip(32); 
  var t3 = new Tweet("3","3",3);System.out.println("""t3  : objsets.Tweet = """ + $show(t3 ));$skip(32); 
  var t4 = new Tweet("4","4",4);System.out.println("""t4  : objsets.Tweet = """ + $show(t4 ));$skip(27); 
  
  var set = new Empty();System.out.println("""set  : objsets.Empty = """ + $show(set ));$skip(28); 
  
  var one = set.incl(t1);System.out.println("""one  : objsets.TweetSet = """ + $show(one ));$skip(25); 
  var two = one.incl(t2);System.out.println("""two  : objsets.TweetSet = """ + $show(two ));$skip(27); 
  var three = two.incl(t3);System.out.println("""three  : objsets.TweetSet = """ + $show(three ));$skip(53); 
  var four = set.incl(t3).incl(t1).incl(t2).incl(t4);System.out.println("""four  : objsets.TweetSet = """ + $show(four ));$skip(24); val res$0 = 
  
  three.contains(t3);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(51); 
  var filtered = three.filter(t => t.retweets > 1);System.out.println("""filtered  : objsets.TweetSet = """ + $show(filtered ));$skip(25); val res$1 = 
   filtered.contains(t1);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(24); val res$2 = 
  filtered.contains(t2);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(24); val res$3 = 
  filtered.contains(t3);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(49); 
        
  var union = one.union(set).union(two);System.out.println("""union  : objsets.TweetSet = """ + $show(union ));$skip(27); val res$4 = 
  
     union.contains(t1);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(21); val res$5 = 
  union.contains(t2);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(21); val res$6 = 
  union.contains(t3);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(26); val res$7 = 
   
  three.mostRetweeted;System.out.println("""res7: objsets.Tweet = """ + $show(res$7));$skip(22); val res$8 = 
    one.mostRetweeted;System.out.println("""res8: objsets.Tweet = """ + $show(res$8));$skip(17); val res$9 = 
  one.remove(t1);System.out.println("""res9: objsets.TweetSet = """ + $show(res$9));$skip(44); 
  three.descendingByRetweet foreach println;$skip(43); 
  four.descendingByRetweet foreach println;$skip(52); val res$10 = 
                           
  TweetReader.allTweets;System.out.println("""res10: objsets.TweetSet = """ + $show(res$10));$skip(45); 
  GoogleVsApple.googleTweets foreach println;$skip(44); 
  GoogleVsApple.appleTweets foreach println;$skip(42); 
   GoogleVsApple.trending foreach println}
  
}
