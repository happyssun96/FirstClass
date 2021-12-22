package com.project.melon.controller.main;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.compiler.ast.Keyword;
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
   private static final Logger logger = LoggerFactory.getLogger(MainController.class);
   
   @Autowired
   private MemberService memberService;
   @Autowired
   private SongService songService;
   
   
   @RequestMapping(value = "clickHomeBtn.do", method = RequestMethod.GET)
   public String clickHomeBtn(HttpSession session, Model model )
   {
         logger.info("Welcome MemberController! clickHomeBtn =");
         
      String viewUrl = "redirect:userMainPage.do";
      
      if(session.getAttribute("member") != null)
      {
         if(((MemberVO)session.getAttribute("member")).getAuth().equals("admin"))
         {
            viewUrl = "redirect:adminUserSearchPage.do";
         }
      }

      
      return viewUrl;
   }
   
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
         
       int totalCount = songService.songSelectTotalCount();  
       System.out.println(totalCount);
      Paging songPaging = new Paging(totalCount, curPage);
      int start = songPaging.getPageBegin();
      int end = songPaging.getPageEnd();
      
      String viewUrl = "/index";
      
      List<SongVO> songList = songService.songSelectList("", start, end);
      
      
      Map<String, Object> pagingMap = new HashMap<String, Object>();
      pagingMap.put("totalCount", totalCount);
      pagingMap.put("songPaging", songPaging);
      
      model.addAttribute("songList", songList);
      model.addAttribute("pagingMap", pagingMap);
      
      return viewUrl;
   }
   
   @RequestMapping(value = "userSearchPage.do", method = RequestMethod.GET)
   public String userSearchList(@RequestParam(defaultValue = "1") int curPage
         ,@RequestParam(defaultValue = "")String keyword, Model model)
   {
      String viewUrl = "userSearchPage";
      
      int totalCount = songService.songSelectTotalCount();
      Paging songPaging = new Paging(totalCount, curPage);
      int start = songPaging.getPageBegin();
      int end = songPaging.getPageEnd();
      
      List<SongVO> songList = songService.songSelectList(keyword, start, end);
      
      Map<String, Object> pagingMap = new HashMap<String, Object>();
      pagingMap.put("totalCount", totalCount);
      pagingMap.put("songPaging", songPaging);
      
      model.addAttribute("keyword", keyword);
      model.addAttribute("songList", songList);
      model.addAttribute("pagingMap", pagingMap);
      
      return viewUrl;
   }
   
   /**
    * @param curPage 현재 페이지를 저장하고 있는 파라미터
    * @param model 프론트로 데이터를 넘겨주기 위한 모델
    * @return
    */
   @RequestMapping(value = "adminMainPage.do", method = RequestMethod.GET)
   public String adminMainPage(@RequestParam(defaultValue = "1")int memberCurPage
         , @RequestParam(defaultValue = "1")int songCurPage
         , HttpSession session, Model model)
   {
         logger.info("Welcome MainController! adminMainPage memberCurpage =" + memberCurPage
               + "\n songCurPage = " + songCurPage);
         
     	String viewUrl = "./auth/authorityError";
    	
    	if(session.getAttribute("member") != null)
    	{
    		MemberVO tempVo = (MemberVO)session.getAttribute("member");
    		if(tempVo.getAuth().equals("admin"))
    		{
    			
    			int songTotalCount = songService.songSelectTotalCount();
    			int memberTotalCount = memberService.memberSelectTotalCount(); 
    			System.out.println(memberTotalCount);
    			System.out.println(songTotalCount);
    			
    			Paging memberPaing = new Paging(memberTotalCount, memberCurPage);
    			int memberStart = memberPaing.getPageBegin();
    			int memberEnd = memberPaing.getPageEnd();
    			
    			Paging songPaging = new Paging(songTotalCount, songCurPage);
    			int songStart = songPaging.getPageBegin();
    			int songEnd = songPaging.getPageEnd();
    			
    			List<SongVO> songList = songService.songSelectList("", songStart, songEnd);
    			System.out.println("songList =" + songService.songSelectList("", songStart, songEnd));
    			List<MemberVO> memberList = memberService.memberSelectList("", memberStart, memberEnd);
    			
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
    			
    			
    			viewUrl = "adminPage"; 
    		}
    	}
         
      
      return viewUrl;
   }
   
   /** 관리자가 유저를 검색했을경우
    * @param curPage 현재 페이지 파라미터
    * @param keyword 검색어 파라미터
    * @param model 프론트 파라미터 전송용 몯ㄹ
    * @return
    */
   @RequestMapping(value = "adminUserSearchPage.do", method = {RequestMethod.GET, RequestMethod.POST})
   public String adminUserSearchList(@RequestParam(defaultValue = "1") int curPage
         ,@RequestParam(defaultValue = "")String keyword, HttpSession session, Model model)
   {
		String viewUrl = "./auth/authorityError";
		
		if(session.getAttribute("member") != null)
		{
			MemberVO tempVo = (MemberVO)session.getAttribute("member");
			if(tempVo.getAuth().equals("admin"))
			{
				
				int totalCount = memberService.memberSelectTotalCount();
				Paging memberPaging = new Paging(totalCount, curPage);
				int start = memberPaging.getPageBegin();
				int end = memberPaging.getPageEnd();
				
				List<MemberVO> memberList = memberService.memberSelectList(keyword, start, end);
				
				Map<String, Object> pagingMap = new HashMap<String, Object>();
				pagingMap.put("totalCount", totalCount);
				pagingMap.put("memberPaging", memberPaging);
				
				model.addAttribute("keyword", keyword);
				model.addAttribute("memberList", memberList);
				model.addAttribute("pagingMap", pagingMap);
				
				viewUrl = "adminUserList";
			}
		}
	   
      return viewUrl;
   }
   
   @RequestMapping(value = "adminSongSearchPage.do", method = {RequestMethod.GET, RequestMethod.POST})
   public String adminSongSearchList(@RequestParam(defaultValue = "1") int curPage
         ,@RequestParam(defaultValue = "")String keyword, HttpSession session, Model model)
   {
	   
		String viewUrl = "./auth/authorityError";
		
		if(session.getAttribute("member") != null)
		{
			MemberVO tempVo = (MemberVO)session.getAttribute("member");
			if(tempVo.getAuth().equals("admin"))
			{
				int totalCount = songService.songSelectTotalCount();
				Paging songPaging = new Paging(totalCount, curPage);
				int start = songPaging.getPageBegin();
				int end = songPaging.getPageEnd();
				
				List<SongVO> songList = songService.songSelectList(keyword, start, end);
				
				Map<String, Object> pagingMap = new HashMap<String, Object>();
				pagingMap.put("totalCount", totalCount);
				pagingMap.put("songPaging", songPaging);
				
				model.addAttribute("keyword", keyword);
				model.addAttribute("songList", songList);
				model.addAttribute("pagingMap", pagingMap);
				
				viewUrl = "adminSongList";		
			}
		}
      
      return viewUrl;
   }
}