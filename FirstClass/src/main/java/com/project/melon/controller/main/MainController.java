package com.project.melon.controller.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.melon.controller.user.UserController;
import com.project.melon.model.MemberVO;
import com.project.melon.model.SongVO;
import com.project.melon.service.MemberService;
import com.project.melon.service.SongService;
import com.project.melon.util.Paging;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private SongService songService;
	
	@RequestMapping(value = "userMainPage.do", method = RequestMethod.GET)
	public String userMainPage(@RequestParam(defaultValue = "1")int curPage, 
			@RequestParam(defaultValue="")String keyword, Model model )
	{
	      logger.info("Welcome MemberController! searchPage curpage =" + curPage + 
	    		  " keyword :" + keyword);
	      
	    int totalCount = songService.songSelectTotalCount(keyword);  
	    System.out.println(totalCount);
		Paging songPaging = new Paging(totalCount, curPage);
		int start = songPaging.getPageBegin();
		int end = songPaging.getPageEnd();
		
		List<SongVO> songList = songService.songSelectList("all" ,keyword, start, end);
		
		
		Map<String, Object> pagingMap = new HashMap<String, Object>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("songPaging", songPaging);
		
		model.addAttribute("songList", songList);
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("keyword", keyword);
		
		return "/WaterMelon/index.jsp";
	}
	
	@RequestMapping(value = "adminMainPage.do", method = RequestMethod.GET)
	public String adminMainPage(@RequestParam(defaultValue = "1")int curPage
			, Model model)
	{
	      logger.info("Welcome MemberController! searchPage curpage =" + curPage);
	      
	    int songTotalCount = songService.songSelectTotalCount("");
	    int memberTotalCount = memberService.memberSelectTotalCount();
	    
	    System.out.println(memberTotalCount);
	    System.out.println(songTotalCount);
	    
	    Paging memberPaing = new Paging(memberTotalCount, curPage);
	    int memberStart = memberPaing.getPageBegin();
	    int memberEnd = memberPaing.getPageEnd();
	    
		Paging songPaging = new Paging(songTotalCount, curPage);
		int songStart = songPaging.getPageBegin();
		int songEnd = songPaging.getPageEnd();
		
		List<SongVO> songList = songService.songSelectList("", memberStart, memberEnd);
		List<MemberVO> memberList = memberService.memberSelectList("all", "", songStart, songEnd);
		
		Map<String, Object> pagingMap = new HashMap<String, Object>();
		pagingMap.put("totalCount", songTotalCount);
		pagingMap.put("songPaging", songPaging);
		
		model.addAttribute("songList", songList);
		model.addAttribute("pagingMap", pagingMap);
		
		return "/WaterMelon/index.jsp";
	}
	
}
