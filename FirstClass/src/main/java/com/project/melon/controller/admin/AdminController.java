package com.project.melon.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.melon.controller.member.MemberController;
import com.project.melon.model.MemberVO;
import com.project.melon.service.MemberServiceImpl;
import com.project.melon.util.Paging;

public class AdminController {
	private static final Logger logger
	= LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberServiceImpl memberService;
	
	//관리자 1. 유저정보 2. 음원정보 검색 admin/searchPage.do
	//1. 유저정보 클릭시
	@RequestMapping(value = "/main/adminlisterMainPage.do", method = RequestMethod.GET)
	public String userDetailInfoPage(Model model) {
	
	//디버깅을 위한 로그 출력 로직
	logger.info("AdminController! UserDetailInfo");
	return "/admin/userInfomation.do";
}
	//2. 음원정보 클릭시
	@RequestMapping(value = "/main/adminlisterMainPage.do", method = RequestMethod.GET)
	public String musicDetailInfoPage(Model model) {
	
	//디버깅을 위한 로그 출력 로직
	logger.info("AdminController! musicDetailInfo");
	
	return "/admin/musicInfomation.do";	
	}
	
	//1. 유저 정보 목록 화면(관리자, 유저 전체 리스트 출력)으로
	@RequestMapping(value = "/admin/userInfomation.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String adminUserInfomation(@RequestParam(defaultValue = "1")int curPage
			, @RequestParam(defaultValue = "")String keyword
			, @RequestParam(defaultValue = "all")String searchOption
			, Model model) {
		
		
		logger.info("memberController!" + "memberList keyword: {}", keyword);
		
		int totalCount = memberService.memberSelectTotalCount();
		
	      // 페이지 나누기 관련 처리
	      Paging memberPaging = new Paging(totalCount, curPage);
	      int start = memberPaging.getPageBegin();
	      int end = memberPaging.getPageEnd();
	      
	      List<MemberVO> memberList = 
	            memberService.memberSelectList(searchOption, keyword, start, end);
	      
	      HashMap<String, Object> searchMap = new HashMap<String, Object>();
	      searchMap.put("keyword", keyword);
	      searchMap.put("searchOption", searchOption);
	      
	      Map<String, Object> pagingMap = new HashMap<String, Object>();
	      pagingMap.put("totalCount", totalCount);
	      pagingMap.put("memberPaging", memberPaging);
	      
	      model.addAttribute("memberList", memberList);
	      model.addAttribute("searchMap", searchMap);
	      model.addAttribute("pagingMap", pagingMap);
	      
		return "auth/userListView";
	}
	
	//admin/update.do [어드민] 유저 세부정보 수정 프론트(회원 수정 화면으로)
	@RequestMapping(value = "/admin/update.do", method = RequestMethod.POST)
	public String userUpdate(int no, Model model) {
		
		logger.info("memberUpdate no" + no);
		
		MemberVO memberVo = memberService.memberSelectOne(no);
		
		model.addAttribute("memberVo", memberVo);
		
		return "/admin/MemberUpdateForm";
	}
	
	//어드민 계정에서 회원 정보를 수정하는 로직 (관리자 권한 부여 포함)
	@RequestMapping(value = "/admin/updateCtr.do", method = RequestMethod.POST)
	public String userUpdate(MemberVO memberVo, HttpSession session, Model model) {
		
		logger.info("memberUpdateCtr" + memberVo);
		
		memberService.memberUpdateOne(memberVo);
		
		if (session.getAttribute("member") != null) { //세션정보있는지 확인
			MemberVO tempVo = (MemberVO)session.getAttribute("member");
			if (tempVo.getMember_no() == memberVo.getMember_no()) {
				session.setAttribute("member", memberService.memberSelectOne(memberVo.getMember_no()));
			}
		}
		return "/common/successPage";
	}
	
	//어드민 회원삭제 로직 adminAccountDeleteCtr.do
	@RequestMapping(value = "/admin/adminAccountDeleteCtr.do", method = RequestMethod.GET)
	public String userAccountDelete(MemberVO memberVo, int no, HttpSession session, Model model) {
		
		logger.info("memberDeleteCtr" + no);
		
		if (session.getAttribute("memberVo") != null) { //세션정보있는지 확인
			MemberVO sessionVo = (MemberVO)session.getAttribute("member");
			if (sessionVo.getMember_no() == memberVo.getMember_no()) {
				session.invalidate();
				memberService.memberDeleteOne(no);
				return "redirect:/login.do";
			}
		}
		memberService.memberDeleteOne(no);
		return "redirect:/member/list.do";
		
	}
	
	
	
	
	
	
	
}
