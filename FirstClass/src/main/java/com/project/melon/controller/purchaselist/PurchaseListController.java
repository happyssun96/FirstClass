package com.project.melon.controller.purchaselist;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.melon.model.MemberVO;
import com.project.melon.service.MemberService;
import com.project.melon.service.PurchaseListService;
import com.project.melon.service.SongService;

@Controller
public class PurchaseListController {
	private static final Logger logger = LoggerFactory.getLogger(PurchaseListController.class);
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private SongService songService;
	@Autowired
	private PurchaseListService purchaseListService;
	
	@RequestMapping(value = "addPurchaseListCtr.do", method = RequestMethod.GET)
		public String addPurchaseListCtr(HttpSession session, int purchaseNo, int purchaseUserNo)
		{
		String viewUrl = "sessionExpire";
			if(session.getAttribute("member") != null)
			{
				purchaseListService.addPurchaseList(purchaseNo, purchaseUserNo);
				viewUrl = "redirect:/userMainPage.do";
			}	
		return viewUrl;
		}

}
