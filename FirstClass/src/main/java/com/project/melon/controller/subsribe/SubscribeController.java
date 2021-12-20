package com.project.melon.controller.subsribe;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.melon.model.MemberVO;
import com.project.melon.model.SubscribeVO;
import com.project.melon.service.MemberService;
import com.project.melon.service.SubscribeService;


public class SubscribeController {
	private static final Logger logger
	= LoggerFactory.getLogger(SubscribeController.class);
	
	@Autowired
	private SubscribeService subscribeService;
	@Autowired
	private MemberService memberService;	
	
	
	//이용권 구매 버튼 클릭시
	@RequestMapping(value = "/subscribe/subscribeList.do", method = RequestMethod.POST)
		public String addSubscribeList(HttpSession session, SubscribeVO subscribeVo, Model model) {
		
		logger.info("subscribeController! loginSubscribe");
		int resultSubscribe = subscribeService.subscribeChk(subscribeVo);		
		
		
		//유저계정 세션이 존재하는지 검증
		//System.out.println(session.getAttribute("member"));
		try {
				
			if (session != null && session.getAttribute("member") != null) {
				
				
				//유저계정 세션을 통해 이용권을 구독중인지 검증
				//구독중인 계정일때
				if (resultSubscribe == 1) {
					
					//이전페이지로 리다이렉트
					return "redirect:/member/Login";
				}
				//미구독중인 계정일때
				else if (resultSubscribe == 0) {
					return "redirect:/subscribe/subscribePurchase";
				}
				
			
			}else {
				//로그인 안되어있을시 에러 페이지 혹은 로그인 페이지로 날리기
				return "auth/playListErr";
			}
			
		} catch (Exception e) {
			// 위에 유저 검증 실행 안되었을때 실행
			e.printStackTrace();
			return "/member/Login.do";
		}
		return "/member/Login.do";
		}
	
	
	// 이용권 최종 결제수행
	@RequestMapping(value = "subscribe/subscribePurchaseCtr.do", method = RequestMethod.POST)
	public String addPlayList(HttpSession session, SubscribeVO subscribeVo, Model model) {
		
		session.getAttribute("member");
		
		MemberVO tempVo = (MemberVO)session.getAttribute("member");
		tempVo.getMember_no();
		int cash = memberService.memberCash(tempVo.getMember_no());
		
		try {
			
			//유저 계정 세션이 존재하는지 검증
			if (session != null && session.getAttribute("member") != null) {
				
				//유저 계정이 보유한 Cash가 구독권 가격보다 높은지 확인
				//[높은 경우]
				if (cash >= 5000) {
					//subscribe insert service 수행, purchaseList insert service 수행
					logger.info("purchaseInsert");
					
					subscribeService.subscribeInsertOne(subscribeVo);
					
					//세션정보 갱신 후 addPurchaseList.do 로 리턴 
					
					MemberVO memberVo = memberService.memberSelectOne(tempVo.getMember_no());
					session.setAttribute("member", memberVo);
					
					return "redirect:/addPurchaseList.do";
				}
				else if (cash < 5000) {
					//[낮은 경우] 
					//보유 캐시가 부족하다는 경고 메시지 출력, 캐시 충전 페이지로 리다이렉트		
					return "/member/purchaseErr";
				}
				
				
				
				
			}else {
				//로그인 안되어있을시 에러 페이지 혹은 로그인 페이지로 날리기
				return "/member/Login.do";
			}
			
		} catch (Exception e) {
			//위에 유저 검증 실행 안되었을때 실행
			e.printStackTrace();
			return "/member/Login.do";
		}
		
		return "redirect:/addPurchaseList.do";
	}
}
