package com.project.melon.controller.playlist;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.melon.model.MemberVO;
import com.project.melon.model.PlayListVO;
import com.project.melon.service.MemberServiceImpl;
import com.project.melon.service.PlayListServiceImpl;

public class PlayListController {
	private static final Logger logger
	= LoggerFactory.getLogger(PlayListController.class);

	@Autowired
	private PlayListServiceImpl playListService;
	
	@RequestMapping(value = "playList/addPlayList.do", method = RequestMethod.GET)
		public String addPlayList(HttpSession session, PlayListVO playListVo, Model model) {
			logger.info("playListAdd");
			
			
			//유저계정 세션이 존재하는지 검증
			try {
				if (session != null && session.getAttribute("member") != null) {
					
					//insertPlayList service 수행
					playListService.playListInsertOne(playListVo);
					
					//이전페이지로 리다이렉트
					return "redirect:/member/PlayList";
				}else {
					//로그인 안되어있을시 에러 페이지 혹은 로그인 페이지로 날리기
					return "auth/playListErr";
				}
				
			} catch (Exception e) {
				// 위에 유저 검증 실행 안되었을때 실행
				e.printStackTrace();
				return "/member/Login.do";
			}
		
		}
	
	@RequestMapping(value = "playList/deletePlayList.do", method = RequestMethod.GET)
		public String deletePlayList(HttpSession session, int no, Model model) {
		
		logger.info("playListDeleteCtr no : " + no);
		
		//유저계정 세션이 존재하는지 검증
		try {
			if (session != null && session.getAttribute("member") != null) {
				
				//deleteplaylist service 수행
				playListService.playListDeleteOne(no);
				
				//이전페이지로 리다이렉트
				return "redirect:/member/PlayList";
			}else {
				//로그인 안되어있을시 에러 페이지 혹은 로그인 페이지로 날리기
				return "auth/playListErr";
			}
			
		} catch (Exception e) {
			// 위에 if문 실행이 되지 않았을때 실행
			e.printStackTrace();
			return "/member/Login.do";
		}
		
		
		
		
	}
	
	
	
	
	
}
