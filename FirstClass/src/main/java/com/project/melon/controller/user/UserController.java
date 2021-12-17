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
	
		
		@RequestMapping(value = "userDetailInformation.do", method = RequestMethod.GET)
			public String userDetailInformation(HttpSession session, String password, Model model)
			{
		      logger.info("Welcome userController! userDetailInformation password :" + password);
			// 원래는 사용자 비밀번호를 입력받고 해야하지만 우선은 패스
			
			if(session.getAttribute("member") != null)
				{
					MemberVO tempVo = (MemberVO) session.getAttribute("member");
				
				if(tempVo.getPassword().equals(password))
					{
					model.addAttribute(tempVo);
					return "main/user/UserDetailInformationForm";	
					}
				}
				return "main/user/UserValidFail"; // 비밀번호가 일치하지 않는경우 비밀번호 검증 실패 페이지로 이동
			}
		
		@RequestMapping(value = "update.do", method = RequestMethod.POST)
			public String userUpdate(MemberVO memberVo, HttpSession session)
			{
		      logger.info("Welcome MemberController! login");
		      if(session.getAttribute("member") != null)
		      {
				
					memberService.memberUpdateOne(memberVo);
					return "";
		      }
				return "auth/sessionexpired"; //로그인 정보가 존재하지 않을경우 페이지 이동
			}
		
		@RequestMapping(value = "userAccountDismiss.do", method = RequestMethod.GET)
			public String userAccountDismiss(HttpSession session) {
			MemberVO tempVo = (MemberVO)session.getAttribute("member");
			memberService.memberDeleteOne(tempVo.getMember_no());
			return "";
		}
}
