package com.project.melon.controller.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.melon.model.MemberVO;
import com.project.melon.service.MemberService;

@Controller
public class MemberController {

		private static final Logger logger
			= LoggerFactory.getLogger(MemberController.class);
		
		@Autowired
		private MemberService memberService;
		
		//login.do 로그인 폼으로 이동하기 위한 구문
		@RequestMapping(value = "/login.do", method = RequestMethod.GET)
		public String login(HttpSession session, Model model) {
			//디버깅을 위한 로그 출력 로직
			logger.info("MemberController! login");
			//login form으로 이동 시키는 로직
			return "auth/LoginForm";
		}
		
		//loginCtr.do 로그인 작업을 수행하기위한 구문(DB 활용)
		@RequestMapping(value = "/loginCtr.do", method = RequestMethod.POST)
		public String loginCtr(@Valid String email, String password, HttpSession session, Model model) {
			//디버깅을 위한 로그 출력 로직
			logger.info("MemberController! loginCtr" + email + ", " + password);
	
			MemberVO memberVo = memberService.memberExist(email, password);
	
			//암호화 valid 기능을 통해 패스워드 검증 수행?? - 뭔소린지 모르겠음
			
			//로그인 정보 존재여부 확인
			if (memberVo != null) {
	
				//로그인 성공시 session 정보 추가
				session.setAttribute("member", memberVo);
				
				//회원종류(관리자, 유저)에 따라 로그인
				if (memberVo.getAuth().equals("user")) {
					
					//주소창의 경우 앞에 / 하지 않을 경우 잘못된 주소로 이동할 것 같아 추가
					return "redirect:userMainPage.do";	
				}else {
					return "redirect:/adminUserSearchPage.do";
				}				
			}else {
				return "auth/LoginFail";
			}
		}
	
		//logout.do 로그아웃 작업을 수행하기 위한 구문
		@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
		public String logout(HttpSession session, Model model) {
			logger.info("MemberController! logout");
			
			//세션 정보 해지
			session.invalidate();
			
			//로그인창으로 리다이렉트
			return "redirect:/userMainPage.do";
		}
		
		//회원가입 작업을 수행하기위한 구문(회원가입 폼으로 이동)
		@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
		public String memberAdd(Model model) {
			logger.info("MemberController! memberAdd");
			
			return "member/RegisterForm";
		}
	
		//이메일 중복체크
		@RequestMapping(value = "/emailChk.do", method = RequestMethod.POST)
		public int emailChk(MemberVO memberVo, Model model) {
			
			int resultEmail = memberService.emailChk(memberVo);
			
			return resultEmail;
		}
		
		//닉네임 중복체크
		@RequestMapping(value = "/nickNameChk.do", method = RequestMethod.POST)
		public int nickNameChk(MemberVO memberVo, Model model) {
			
			int resultNickName = memberService.nickNameChk(memberVo);
			
			return resultNickName;
		}

		//회원가입 데이터통신 및 처리를 위한 구문
		@RequestMapping(value = "/member/addCtr.do", method = RequestMethod.POST)
		public String memberAdd(MemberVO memberVo, Model model) {
			
			logger.info("MemberController! memberAdd" + memberVo);
			
			int resultEmail = memberService.emailChk(memberVo);
			int resultNickName = memberService.nickNameChk(memberVo);
			try {
				//이메일 중복이 있을때
				if (resultEmail == 1) {
					//이메일 에러 페이지로
					return "auth/emailError";
				}
				//이메일에 중복이없을때
				else if (resultEmail == 0) {
					
					//닉네임에 중복이 있을때
					if (resultNickName == 1) {
						//닉네임 에러 페이지로
						return "auth/nickNameError";
					}
					
					//닉네임, 이메일 모두 중복이 없을때
					else if (resultNickName == 0) {
						//저장
						memberService.memberInsertOne(memberVo);
						//로그인 페이지로
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "redirect:/login.do";
			}
			
			//실행이 완료되었다면 로그인 페이지로
			return "redirect:/login.do";
			
			
		}

	
	
	
	
}
