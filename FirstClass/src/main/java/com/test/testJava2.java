package com.test;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class testJava2 {
   public static void main(String[] args) {
      try {
         String URL = "https://www.melon.com/chart/index.htm";

         Connection conn = Jsoup.connect(URL);

         Document html = conn.get();
         int rank = 1;

         Elements testElm = html.select(".service_list_song");
         System.out.println("testElm = " + testElm);
         
//         for(Element testblock : testElm)
//         {
//        	 String songName = testblock.getElementsByClass("title ellipsis").text();
//        	 System.out.println(songName);
//         }
         
         Elements fileblocks = html.getElementsByClass("list-wrap");
//         for( Element fileblock : fileblocks)
//         {
//            Elements files = fileblock.getElementsByClass("info");
////            files.text();
////            System.out.println("files =" + files);
//            System.out.println("순위 \t곡명 \t\t\t\t 가수명 \t\t\t 앨범명");
//            System.out.println("===================================================================================================");
//            for( Element elm : files) {
//               String songName = elm.getElementsByClass("title ellipsis").text();
//               String songArtist = elm.getElementsByClass("artist ellipsis").text();
//               String songAlbum = elm.getElementsByClass("albumtitle ellipsis").text(); 
//               System.out.print(" " +rank +"\t || \t");
//               System.out.print(songName +"\t || \t");
//               System.out.print(songArtist + "\t || \t");
//               System.out.println(songAlbum + "\t || \t");
//               rank++;
//               System.out.println("===================================================================================================");
//            }
//         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}