package com.project.melon.controller.subsribe;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.melon.model.MemberVO;
import com.project.melon.model.SubscribeVO;
import com.project.melon.service.MemberService;
import com.project.melon.service.PurchaseListService;
import com.project.melon.service.SubscribeService;

@Controller
public class SubscribeController {
	private static final Logger logger
	= LoggerFactory.getLogger(SubscribeController.class);
	
	@Autowired
	private SubscribeService subscribeService;
	@Autowired
	private MemberService memberService;	
	@Autowired
	private PurchaseListService purchaseListService;
	//이용권 구매 버튼 클릭시
	@RequestMapping(value = "subscribePurchasePage.do", method = RequestMethod.GET)
		public String addSubscribeList(HttpSession session, SubscribeVO subscribeVo, Model model) {
		
		logger.info("subscribeController! loginSubscribe");
		int resultSubscribe = subscribeService.subscribeChk(subscribeVo);		
		String viewUrl = "./auth/authorityError";
		
		//유저계정 세션이 존재하는지 검증
		//System.out.println(session.getAttribute("member"));
		try {
				
			if (session != null && session.getAttribute("member") != null) {
				
				
				//유저계정 세션을 통해 이용권을 구독중인지 검증
				//구독중인 계정일때
				if (resultSubscribe == 1) {
					
					//이전페이지로 리다이렉트
					return "redirect:/userMainPage.do";
				}
				//미구독중인 계정일때
				else if (resultSubscribe == 0) {
					return "./subscribePurchase";
				}
				
			
			}else {
				//로그인 안되어있을시 에러 페이지 혹은 로그인 페이지로 날리기
				return viewUrl;
			}
			
		} catch (Exception e) {
			// 위에 유저 검증 실행 안되었을때 실행
			e.printStackTrace();
			return "/auth/Login.do";
		}
		return "/auth/Login.do";
		}
	
	//최종결제 화면으로
	@RequestMapping(value = "subscribePurchaseDelayDecision.do", method = RequestMethod.GET)
	public String delayPurchase(int subscribePrice, HttpSession session, Model model) {
		
		MemberVO tempVo = (MemberVO)session.getAttribute("member");
		
		int currentCash = tempVo.getCash();
		int remainCash = currentCash - subscribePrice;
		
		model.addAttribute("subscribePrice", subscribePrice);
		model.addAttribute("currentCash", currentCash);
		model.addAttribute("remainCash", remainCash);
		
		
		
		return "/purchaseDecision";
		
	}
	
	
	
	
	// 이용권 최종 결제수행
	@RequestMapping(value = "subscribePurchaseDecision.do", method = RequestMethod.GET)
	public String addPlayList(HttpSession session, int subscribePrice, Model model) {
		
		session.getAttribute("member");
		
		MemberVO tempVo = (MemberVO)session.getAttribute("member");
		int memberNo = tempVo.getMember_no();
		System.out.println("tempVo=" + tempVo);
		int currentCash = tempVo.getCash();
		
		String viewUrl = "redirect:/cashPurchasePage.do?no="+memberNo;

			
			//유저 계정 세션이 존재하는지 검증
			if (session != null && session.getAttribute("member") != null) {
				
				//유저 계정이 보유한 Cash가 구독권 가격보다 높은지 확인
				//[높은 경우]
				if (currentCash >= subscribePrice) {
					//subscribe insert service 수행, purchaseList insert service 수행
					logger.info("purchaseInsert");
					
					subscribeService.subscribeInsertOne(memberNo);
					
					SubscribeVO subscribeVo = subscribeService.subscribeSelectOne(memberNo);
					
					System.out.println("subscribeVo = " + subscribeVo);
					
					purchaseListService.addPurchaseList(subscribeVo);
					int finalSubscribePrice = -subscribePrice;
					memberService.memberPurchaseCash(memberNo, finalSubscribePrice);
					//세션정보 갱신 후 addPurchaseList.do 로 리턴 
					
					MemberVO memberVo = memberService.memberSelectOne(tempVo.getMember_no());
					session.setAttribute("member", memberVo);
					
					return "redirect:/userMainPage.do";
				}
				else if (currentCash < 5000) {
					//[낮은 경우] 
					//보유 캐시가 부족하다는 경고 메시지 출력, 캐시 충전 페이지로 리다이렉트		
					return viewUrl;
				}
				
				
				
				
			}else {
				//로그인 안되어있을시 에러 페이지 혹은 로그인 페이지로 날리기
				return "/member/Login.do";
			}
			

		
		return "redirect:/addPurchaseList.do";
	}
	
	
	//남은 캐시 띄우기 remaincash
	@RequestMapping(value = "remainCashCtr.do", method = RequestMethod.POST)
	public String remainCash(HttpSession session, MemberVO memberVo, Model model) {
		
		String viewUrl = "/index";
		
		session.getAttribute("member");
		MemberVO tempVo = (MemberVO)session.getAttribute("member");
		
		//결제전 캐시 - 구독권가격(5000)
		int remaincash = tempVo.getCash() - 5000;
		
		model.addAttribute(remaincash);
		return viewUrl;
	}
	
}
