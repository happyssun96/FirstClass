package com.project.melon.controller.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.melon.service.MemberService;

@Controller
@RequestMapping(value="/user/")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
		@Autowired
		private MemberService memberService;
	
		@RequestMapping(value = "searchPage.do", method = RequestMethod.GET)
			public String userDetailInformation(HttpSession session, Model model)
			{
			return "main/user/UserDetailInformationForm";
			}

}
