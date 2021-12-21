package com.project.melon.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.melon.model.MemberVO;
import com.project.melon.model.SongVO;
import com.project.melon.service.MemberService;
import com.project.melon.service.SongService;
import com.project.melon.util.Paging;

@Controller
//@RequestMapping(value="/user/")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
		@Autowired
		private MemberService memberService;
		@Autowired
		private SongService songService;
	
		
		@RequestMapping(value = "cashPurchasePage.do", method = RequestMethod.GET)
		public String cashPurchasePage(int no, Model model)
		{
			String viewUrl = "./cashPurchase";
			
			MemberVO memberVo = memberService.memberSelectOne(no);
			model.addAttribute("member", memberVo);
			
			return viewUrl;
		}
		
		@RequestMapping(value = "cashDecisionPage.do", method = RequestMethod.GET)
		public String cashDecisionPage(int chosenCash, HttpSession session,  Model model)
		{
			
			String viewUrl = "./auth/sessionExpire";
//			세션 정보 검증
			 viewUrl = "./cashPurchase";
			 
			 if(session.getAttribute("member") != null)
			 {
				int no = ((MemberVO) session.getAttribute("member")).getMember_no();
				MemberVO memberVo = memberService.memberSelectOne(no);
				model.addAttribute("member", memberVo);
				model.addAttribute("chosenCash", chosenCash);
				model.addAttribute("finalCash", memberVo.getCash()+chosenCash);
				
				return "./cashDecision";
			 }
			
			
			
			return viewUrl;
		}
		
		@RequestMapping(value = "addCashCtr.do", method = RequestMethod.GET)
			public String addCashCtr(HttpSession session, @RequestParam(defaultValue = "0")int chosenCash)
			{
				String viewUrl = "/index";
				
				MemberVO tempVo = (MemberVO)session.getAttribute("member");
				System.out.println("userNo =" + tempVo.getMember_no());
				memberService.memberPurchaseCash(tempVo.getMember_no(),chosenCash);
				
				MemberVO memberVo = memberService.memberSelectOne(tempVo.getMember_no());
//				MemberVO userVo = memberService.memberSelectOne(2);
				session.setAttribute("member", memberVo);
				
				return viewUrl;
			}
		@RequestMapping(value = "userDetailInformation.do", method = RequestMethod.GET)
			public String userDetailInformation(HttpSession session, String password, Model model)
			{
		      logger.info("Welcome userController! userDetailInformation password :" + password);
			// 원래는 사용자 비밀번호를 입력받고 해야하지만 우선은 패스
			String viewUrl = "userValidFail";
			
			if(session.getAttribute("member") != null)
				{
					MemberVO tempVo = (MemberVO) session.getAttribute("member");
					MemberVO userVo = memberService.memberSelectOne(tempVo.getMember_no());

//					플레이 리스트가 완성되면 추가
//					PlayListVO playListVo = playListService.selectListPlayList(tempVo.getMember_no());
					
//					model.addAttribute(playListVo);
					model.addAttribute("member", userVo);
					viewUrl = "userDetailPage";
				}
				return viewUrl; // 비밀번호가 일치하지 않는경우 비밀번호 검증 실패 페이지로 이동
			}
		
		@RequestMapping(value = "userUpdateInformation.do", method = RequestMethod.GET)
		public String userDetailInformation(HttpSession session, int no, Model model)
		{
	      logger.info("Welcome userController! userUpdateInformation :");
		// 원래는 사용자 비밀번호를 입력받고 해야하지만 우선은 패스
		String viewUrl = "userValidFail";
		
		if(session.getAttribute("member") != null)
			{
				MemberVO userVo = memberService.memberSelectOne(no);

//				플레이 리스트가 완성되면 추가
//				PlayListVO playListVo = playListService.selectListPlayList(tempVo.getMember_no());
				
//				model.addAttribute(playListVo);
				model.addAttribute("member", userVo);
				viewUrl = "userUpdateForm";
			}
			return viewUrl; // 비밀번호가 일치하지 않는경우 비밀번호 검증 실패 페이지로 이동
		}
		
		@RequestMapping(value = "userSongDetailInformation.do", method = RequestMethod.GET)
		public String userSongDetailInformation(HttpSession session, int no, Model model)
		{
	      logger.info("Welcome userController! userDetailInformation no :" + no);
		// 원래는 사용자 비밀번호를 입력받고 해야하지만 우선은 패스
		String viewUrl = "userValidFail";
		
//		if(session.getAttribute("member") != null)
//			{
				SongVO songVo = songService.songSelectOne(no);
				
				
//				model.addAttribute(playListVo);
				model.addAttribute("songVo",songVo);
				viewUrl = "songDetailPage";
//			}
			return viewUrl; // 비밀번호가 일치하지 않는경우 비밀번호 검증 실패 페이지로 이동
		}
		
		@RequestMapping(value = "userUpdateCtr.do", method = RequestMethod.POST)
			public String userUpdate(MemberVO memberVo,int no, HttpSession session)
			{
		      logger.info("Welcome MemberController! login");
		      String viewUrl = "sessionExpired";
		      
		      if(session.getAttribute("member") != null)
		      {
					memberService.memberUpdateOne(memberVo);
					viewUrl = "userDetailPage";
		      }
				return viewUrl; //로그인 정보가 존재하지 않을경우 페이지 이동
			}
		
		@RequestMapping(value = "userAccountDismiss.do", method = RequestMethod.GET)
			public String userAccountDismiss(HttpSession session) {
			String viewUrl = "index";
			
			MemberVO tempVo = (MemberVO)session.getAttribute("member");
			memberService.memberDeleteOne(tempVo.getMember_no());
			
			session.invalidate();
			
			return viewUrl;
		}
		
		
}