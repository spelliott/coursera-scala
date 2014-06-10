package objsets
import common._
import objsets._
import TweetData._
import TweetReader._
 
 
object ws {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  var t1 = new Tweet("1","1",1)                   //> t1  : objsets.Tweet = User: 1
                                                  //| Text: 1 [1]
  var t2 = new Tweet("2","2",2)                   //> t2  : objsets.Tweet = User: 2
                                                  //| Text: 2 [2]
  var t3 = new Tweet("3","3",3)                   //> t3  : objsets.Tweet = User: 3
                                                  //| Text: 3 [3]
  var t4 = new Tweet("4","4",4)                   //> t4  : objsets.Tweet = User: 4
                                                  //| Text: 4 [4]
  
  var set = new Empty()                           //> set  : objsets.Empty = objsets.Empty@5858ba4b
  
  var one = set.incl(t1)                          //> one  : objsets.TweetSet = objsets.NonEmpty@292ebf3d
  var two = one.incl(t2)                          //> two  : objsets.TweetSet = objsets.NonEmpty@50b98ef4
  var three = two.incl(t3)                        //> three  : objsets.TweetSet = objsets.NonEmpty@46585e93
  var four = set.incl(t3).incl(t1).incl(t2).incl(t4)
                                                  //> four  : objsets.TweetSet = objsets.NonEmpty@53a928f9
  
  three.contains(t3)                              //> res0: Boolean = true
  var filtered = three.filter(t => t.retweets > 1)//> filtered  : objsets.TweetSet = objsets.NonEmpty@7b20f29d
   filtered.contains(t1)                          //> res1: Boolean = false
  filtered.contains(t2)                           //> res2: Boolean = true
  filtered.contains(t3)                           //> res3: Boolean = true
        
  var union = one.union(set).union(two)           //> union  : objsets.TweetSet = objsets.NonEmpty@50b98ef4
  
     union.contains(t1)                           //> res4: Boolean = true
  union.contains(t2)                              //> res5: Boolean = true
  union.contains(t3)                              //> res6: Boolean = false
   
  three.mostRetweeted                             //> res7: objsets.Tweet = User: 3
                                                  //| Text: 3 [3]
    one.mostRetweeted                             //> res8: objsets.Tweet = User: 1
                                                  //| Text: 1 [1]
  one.remove(t1)                                  //> res9: objsets.TweetSet = objsets.Empty@58cdd92e
  three.descendingByRetweet foreach println       //> User: 3
                                                  //| Text: 3 [3]
                                                  //| User: 2
                                                  //| Text: 2 [2]
                                                  //| User: 1
                                                  //| Text: 1 [1]
  four.descendingByRetweet foreach println        //> User: 4
                                                  //| Text: 4 [4]
                                                  //| User: 3
                                                  //| Text: 3 [3]
                                                  //| User: 2
                                                  //| Text: 2 [2]
                                                  //| User: 1
                                                  //| Text: 1 [1]
                           
  TweetReader.allTweets                           //> res10: objsets.TweetSet = objsets.NonEmpty@99b2061
  GoogleVsApple.googleTweets foreach println      //> User: engadget
                                                  //| Text: AT&amp;T 4G LTE adds Galaxy Note 2, Galay Tab 2 10.1, Galaxy Express a
                                                  //| nd Galaxy Rugby Pro to lineup -  http://t.co/uvBFFMQO [12]
                                                  //| User: gadgetlab
                                                  //| Text: BlueStacks and AMD Bring 500,000 Android Apps to Windows 8: http://t.c
                                                  //| o/GskuXhRo by @alexandra_chang [22]
                                                  //| User: CNET
                                                  //| Text: Camera contest:  Apple iPhone 5 vs. Samsung Galaxy S3 vs. HTC One X ht
                                                  //| tp://t.co/PmbhNgrd [49]
                                                  //| User: engadget
                                                  //| Text: Court of Appeals for the Federal Circuit tells Judge Koh to revisit Ga
                                                  //| laxy Tab 10.1 injunction -  http://t.co/iIOCcwDW [13]
                                                  //| User: engadget
                                                  //| Text: Cubify lets you skin, 3D print your own personal Android -  http://t.c
                                                  //| o/S6nimh5R [23]
                                                  //| User: engadget
                                                  //| Text: FAVI's $50 Streaming Stick adds apps, streaming services to any HDTV w
                                                  //| ith Android 4.1 Jelly Bean -  http://t.co/dL9geyBU [20]
                                                  //| User: gadgetlab
                                                  //| Text: First iPhone 5 Benchmarks: Screaming Fast, Yes, But Just Shy of Galaxy
                                                  //|  S III  http://t.co/QIAhda3L 
                                                  //| Output exceeds cutoff limit.
  GoogleVsApple.appleTweets foreach println       //> User: gadgetlab
                                                  //| Text: #Apple #iPhone5 camera is 8megapixels...same as iPhone 4S. But it's no
                                                  //| t the same camera http://t.co/DwtKQkSu #LIVEBLOG [30]
                                                  //| User: gadgetlab
                                                  //| Text: "We've updated every aspect of iPhone 5,? @PSchiller says. #Apple #iPh
                                                  //| one5 LIVEBLOG http://t.co/DwtKQkSu [16]
                                                  //| User: gadgetlab
                                                  //| Text: #Apple #iPhone5 has 40% faster photo capture thanks iPhone 4S http://t
                                                  //| .co/DwtKQkSu LIVEBLOG [17]
                                                  //| User: gadgetlab
                                                  //| Text: #Apple now talking iOS 6 updates for the #iPhone5 http://t.co/DwtKQkSu
                                                  //|  LIVEBLOG [25]
                                                  //| User: gadgetlab
                                                  //| Text: #Apple: More than 700,000 apps in App Store &amp; 250,000 specifically
                                                  //|  for iPad http://t.co/DwtKQkSu #iPhone5 LIVEBLOG by @redgirlsays [6]
                                                  //| User: gadgetlab
                                                  //| Text: #iOS6 hits the iPhone 4S, 4, 3GS, 3rd-gen iPad, iPad 2 &amp; 4th-gen i
                                                  //| Pod Touch on Sept. 19 http://t.co/DwtKQkSu #Apple #iPhone5 LIVEBLOG [42]
                                                  //| User: gadgetlab
                                                  //| Text: #iPhone5 costs the same as the iPhone 4S: $199 for 16 Gb, $200
                                                  //| Output exceeds cutoff limit.
   GoogleVsApple.trending foreach println         //> User: gizmodo
                                                  //| Text: iPhone 5's brain dissected. Guess what, it's made by Samsung. http://
                                                  //| t.co/wSyjvpDc [321]
                                                  //| User: gizmodo
                                                  //| Text: Warning: Security bug can wipe out your Android phone just by visitin
                                                  //| g a web page-not only limited to Samsung http://t.co/0y6vnOKw [290]
                                                  //| User: gizmodo
                                                  //| Text: The weirdest thing people hate about the iPhone 5: http://t.co/GMwuRp
                                                  //| 8D [202]
                                                  //| User: mashable
                                                  //| Text: iPad 4 Has Carbon Fiber Body, Flexible Display [REPORT] http://t.co/D
                                                  //| ft5VoXD via @tabtimes [198]
                                                  //| User: gizmodo
                                                  //| Text: The definitive comparison of iOS 5 Google Maps vs iOS 6 Apple Maps in
                                                  //|  one single image: http://t.co/fTwTfVMy [191]
                                                  //| User: mashable
                                                  //| Text: iOS 6 Users Complain About Wi-Fi, Connectivity Issues - http://t.co/i
                                                  //| ogRstNn [180]
                                                  //| User: CNET
                                                  //| Text: RT @CNETNews: Apple "fell short" with iOS 6 maps, and we are "extreme
                                                  //| ly sorry," CEO Tim Cook says in open letter http://t.co/t1U4497r [139]
                                                  //| User:
                                                  //| Output exceeds cutoff limit.
  
}