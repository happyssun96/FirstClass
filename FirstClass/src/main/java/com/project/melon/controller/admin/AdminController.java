package com.project.melon.controller.admin;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.project.melon.model.MemberVO;
import com.project.melon.model.SongVO;
import com.project.melon.service.MemberServiceImpl;
import com.project.melon.service.SongService;
import com.project.melon.service.SongServiceImpl;
import com.project.melon.util.Paging;

@Controller
public class AdminController {
	private static final Logger logger
	= LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private MemberServiceImpl memberService;
	@Autowired 
	SongServiceImpl songService;
	//관리자 1. 유저정보 2. 음원정보 검색 admin/searchPage.do
	//1. 유저정보 클릭시
	@RequestMapping(value = "adminUserDetailInformation.do", method = RequestMethod.GET)
	public String userDetailInfoPage(@RequestParam(defaultValue = "0") int no, HttpSession session, Model model) {
	//디버깅을 위한 로그 출력 로직
	logger.info("AdminController! UserDetailInfo no =" + no);
	
	String viewUrl = "./authorityError";
	
	if(session.getAttribute("MemberVo") != null)
	{
		MemberVO tempVo = (MemberVO)session.getAttribute("MemberVo");
		if(tempVo.getAuth().equals("admin"))
		{
			MemberVO memberVo = memberService.memberSelectOne(no);
			model.addAttribute("member", memberVo);
			viewUrl = "adminSongDetailPage"; 
		}
	}
	
	return viewUrl;
}
//	//2. 음원정보 클릭시
	@RequestMapping(value = "adminSongDetailInformation.do", method = RequestMethod.GET)
	public String musicDetailInfoPage(int no, HttpSession session, Model model) {
	//디버깅을 위한 로그 출력 로직
	logger.info("AdminController! musicDetailInfo no = " + no);
	
	
	String viewUrl = "authorityError";
	
	if(session.getAttribute("member") != null)
	{
		MemberVO tempVo = (MemberVO)session.getAttribute("member");
		if(tempVo.getAuth().equals("admin"))
		{
			SongVO songVo = (SongVO)songService.songSelectOne(no);
			
			model.addAttribute("songVo", songVo);
			
			viewUrl = "adminSongDetailPage"; 
		}
	}
	
	return viewUrl;	
	}
	
	@RequestMapping(value = "adminSongUpdateForm.do", method = RequestMethod.GET)
	public String musicUpdate(int no, HttpSession session, Model model) {
	//디버깅을 위한 로그 출력 로직
	logger.info("AdminController! musicUpdate songVo = " + no);
	
	
	String viewUrl = "authorityError";
	
	if(session.getAttribute("member") != null)
	{
		MemberVO tempVo = (MemberVO)session.getAttribute("member");
		if(tempVo.getAuth().equals("admin"))
		{
			SongVO songVo = (SongVO)songService.songSelectOne(no);
			
			model.addAttribute("songVo", songVo);
			
			viewUrl = "adminSongUpdatePage"; 
		}
	}
	return viewUrl;	
	}
	
	@RequestMapping(value = "adminSongUpdateCtr.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String musicUpdateCtr(SongVO songVo
			, MultipartFile uploadSongFile
			, MultipartFile uploadSongImageFile
			, HttpSession session ,Model model) {
	//디버깅을 위한 로그 출력 로직
	logger.info("AdminController! musicUpdate songVo = " + songVo
			+ "\nuploadSongFile =" + uploadSongFile + "\nuSIF =" + uploadSongImageFile);
	
	String viewUrl = "authorityError";
	
	if(session.getAttribute("member") != null)
	{
		MemberVO tempVo = (MemberVO)session.getAttribute("member");
		if(tempVo.getAuth().equals("admin"))
		{
			if(uploadSongFile.isEmpty() == false)
			{
				String uploadSongFolder = "C:\\gitRepository\\WaterMelon\\FirstClass\\src\\main\\webapp\\resources\\song";
				String fullSongName = uploadSongFile.getOriginalFilename();
				
				File uploadSong = new File(uploadSongFolder, fullSongName);
				String songFullPath = "resources/song" + "/" + fullSongName;
				songVo.setMusicResourcePath(songFullPath);
				
				try {
					uploadSongFile.transferTo(uploadSong);
					logger.info("upload complete!!");
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(uploadSongImageFile.isEmpty() == false)
			{
				String uploadSongImageFolder = "C:\\gitRepository\\WaterMelon\\FirstClass\\src\\main\\webapp\\resources\\cover";
				String fullSongImageName = uploadSongImageFile.getOriginalFilename();
				
				File uploadSongImage = new File(uploadSongImageFolder, fullSongImageName);
				
				String songImageFullPath = "resources/cover" + "/" + fullSongImageName;
				
				songVo.setAlbumImagePath(songImageFullPath);
				
				try {
					uploadSongImageFile.transferTo(uploadSongImage);
					logger.info("upload complete!!");
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			songService.songUpdateOne(songVo);
			viewUrl = "redirect:./clickHomeBtn.do"; // 어드민 계정검증이 완료되었으므로 음악 업로드 폼으로 이동
		}
	}
	
	
	
	return viewUrl;	
	}
//	
//	//admin/update.do [어드민] 유저 세부정보 수정 프론트(회원 수정 화면으로)
	   @RequestMapping(value = "/adminUserUpdate.do", method = RequestMethod.GET)
	   public String userUpdate(int no, HttpSession session, Model model) {
	      
	      logger.info("adminUserUpdate no" + no);
	      
			String viewUrl = "authorityError";
			
			if(session.getAttribute("member") != null)
			{
				MemberVO tempVo = (MemberVO)session.getAttribute("member");
				if(tempVo.getAuth().equals("admin"))
				{
					MemberVO memberVo = memberService.memberSelectOne(no);
					
					model.addAttribute("member", memberVo);
					
					viewUrl = "adminUserUpdateForm"; 
				}
			}
	      
	      
	      return viewUrl;
	   }
//	
//	//어드민 계정에서 회원 정보를 수정하는 로직 (관리자 권한 부여 포함)
	@RequestMapping(value = "/adminUserUpdateCtr.do", method = RequestMethod.POST)
	public String userUpdate(MemberVO memberVo, HttpSession session, Model model) {
		
		logger.info("adminUserUpdateCtr" + memberVo);
		
		memberService.memberUpdateOne(memberVo);
		
		if (session.getAttribute("member") != null) { //세션정보있는지 확인
			MemberVO tempVo = (MemberVO)session.getAttribute("member");
			if (tempVo.getMember_no() == memberVo.getMember_no()) {
				session.setAttribute("member", memberService.memberSelectOne(memberVo.getMember_no()));
			}
		}
		return "redirect:adminUserDetailInformation.do?no=" + memberVo.getMember_no();
	}
	
	//어드민 회원삭제 로직 adminAccountDeleteCtr.do
	@RequestMapping(value = "/adminAccountDeleteCtr.do", method = RequestMethod.GET)
	public String userAccountDelete(MemberVO memberVo, int no, HttpSession session, Model model) {
		
		logger.info("memberDeleteCtr" + no);
		
		if (session.getAttribute("member") != null) { //세션정보있는지 확인
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
