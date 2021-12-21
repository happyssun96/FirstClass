package com.project.melon.controller.crawling;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.melon.model.MelonVO;
import com.project.melon.service.CrawlingService;

@Controller
public class CrawlingController {

	@Autowired
	private CrawlingService crawlingService;
	
	//
	@RequestMapping(value = "/crawling.do", method = RequestMethod.GET)
	public String Crawling() {
		String url = "https://www.melon.com/chart/index.htm";
		Document doc = null;
		Elements tmp;
		String name_temp = null;
		String singer_temp = null;
		String album_temp = null;
		int mrank = 0;
		
		try {
			doc = Jsoup.connect(url).get();
//			System.out.println(doc);
		} catch (Exception e) {

			// TODO: handle exception
			e.printStackTrace();
		}
		
		//top 10 가져오기
		
		Elements element = doc.select("#tb_list").select("tr.lst50");
		
//		System.out.println(element);
		
		for (int i = 0; i < 10; i++) {
			
				//이름 가져오기
				tmp = element.select(".rank01").select("span");
				name_temp = tmp.get(i).text();
//				System.out.println(name_temp);
				
//				//가수 가져오기
				tmp = element.select(".rank02").select("span");
				singer_temp = tmp.get(i).text();
//				
//				//앨범 가져오는 과정
				tmp = element.select(".rank03");
				album_temp = tmp.get(i).text();
//				
//				//등수를 가져오는 과정
				tmp = element.select(".rank").select("span");
				mrank = Integer.parseInt((tmp.get(i).text()));
//				System.out.println(rank);
//				
//				//arraylist에 삽입
				MelonVO tmpVo = new MelonVO(mrank, name_temp, singer_temp, album_temp);
				System.out.println(tmpVo);

				crawlingService.MelonInsert(tmpVo);
				
				
				
		}
//		System.out.println("Crawling Complete");
		return "/login.do";
	}
	
	
	//크롤링 실행전 무조건 db초기화 시키기 위해 필요한 삭제구문
	@RequestMapping(value = "/crawlingDelete.do", method = RequestMethod.GET)
	public String CrawlingDelete() {
		
		crawlingService.MelonDelete();
		
		return "/login.do";
	
	}
	
	
}
