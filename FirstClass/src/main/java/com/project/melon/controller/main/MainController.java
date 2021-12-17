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
	
	/**
	 * @param curPage 현재 페이지를 저장하고 있는 파라미터
	 * @param model 프론트로 데이터를 넘겨주기 위한 모델
	 * @return
	 */
	@RequestMapping(value = "userMainPage.do", method = RequestMethod.GET)
	public String userMainPage(@RequestParam(defaultValue = "1")int curPage
			, Model model )
	{
	      logger.info("Welcome MemberController! searchPage curpage =" + curPage);
	      
	    int totalCount = songService.songSelectTotalCount("");  
	    System.out.println(totalCount);
		Paging songPaging = new Paging(totalCount, curPage);
		int start = songPaging.getPageBegin();
		int end = songPaging.getPageEnd();
		
		List<SongVO> songList = songService.songSelectList("", start, end);
		
		
		Map<String, Object> pagingMap = new HashMap<String, Object>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("songPaging", songPaging);
		
		model.addAttribute("songList", songList);
		model.addAttribute("pagingMap", pagingMap);
		
		return "/WaterMelon/index.jsp";
	}
	
	/**
	 * @param curPage 현재 페이지를 저장하고 있는 파라미터
	 * @param model 프론트로 데이터를 넘겨주기 위한 모델
	 * @return
	 */
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
		
		Map<String, Object> songPagingMap = new HashMap<String, Object>();
		songPagingMap.put("songTotalCount", songTotalCount);
		songPagingMap.put("songPaging", songPaging);
		
		Map<String, Object> memberPagingMap = new HashMap<String, Object>();
		memberPagingMap.put("memberTotalCount", memberTotalCount);
		memberPagingMap.put("memberPaging", memberPaing);
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("songList", songList);
		
		model.addAttribute("pagingMap", songPagingMap);
		model.addAttribute("memberPagingMap", memberPagingMap);
		
		return "/WaterMelon/adminPage";
	}
	
}
