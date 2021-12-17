package com.project.melon.controller.subsribe;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.melon.model.MemberVO;
import com.project.melon.service.MemberService;
import com.project.melon.service.SubscribeService;


public class SubscribeController {
	private static final Logger logger
	= LoggerFactory.getLogger(SubscribeController.class);
	
	@Autowired
	private SubscribeService subscribeService;
	@Autowired
	private MemberService memberService;
		
	//이용권 구매창으로 이동하기 위한 구문 /subscribeList.do
	@RequestMapping(value = "/subscribeList.do", method = RequestMethod.GET)
		public String subcribeList(HttpSession session, Model model) {
			logger.info("SubscribeController!");
		//Subscribe form으로 이동 시키는 로직
			return "auth/SubscribeForm";
		}	
	
	//이용권 구매 버튼 클릭시
	@RequestMapping(value = "/subscribe/subscribeList.do", method = RequestMethod.GET)
		public String addSubscribeList(HttpSession session, MemberVO memberVo, Model model) {
		
		logger.info("subscribeController! loginSubscribe");
		
		return "/index.jsp";
	}
}
