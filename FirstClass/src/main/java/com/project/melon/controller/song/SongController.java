package com.project.melon.controller.song;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.melon.model.MemberVO;
import com.project.melon.model.SongVO;
import com.project.melon.service.SongService;
import com.project.melon.service.SubscribeService;

@Controller
//@RequestMapping(value="/song/")
public class SongController {
	private static final Logger logger = LoggerFactory.getLogger(SongController.class);
	
	@Autowired
	private SongService songService;
//	@Autowired
//	private SubscribeService subscribeService;
	
//	@RequestMapping(value = "playMusic.do", method = RequestMethod.GET)
//	public String playMusic(int songNumber, HttpSession session)
//	{
//		logger.info("Welcome SongController! playMusic : songNumber =" + songNumber);
//		if(session.getAttribute("memberVo") != null)
//		{
//			MemberVo tempVo = (MemberVo)session.getAttribute("memberVo");
//			if(subscribeService.subscribeExist(tempVo.getMember_no()) != null)
//			{
//				songService.playFullMusic(songNumber);
//			}
//		}
//		songService.playExperienceMusic(songNumber);
//		return "";
//	}
//	
	
	
	
	@RequestMapping(value = "song/uploadMusic.do", method=RequestMethod.GET)
	public String uploadMusic(HttpSession session, Model model)
	{
		logger.info("Welcome SongController! uploadMusic");
//		if(session.getAttribute("MemberVo") != null)
//		{
//			MemberVo tempVo = (MemberVo)session.getAttribute("MemberVo");
//			if(tempVo.getAuth().equals("adminlister"))
//			{
//				return "song/songUploadForm"; // 어드민 계정검증이 완료되었으므로 음악 업로드 폼으로 이동
//			}
//		}
//		return "auth/authorityError"; // 그 외의 경우 권한이 없으므로 에러 페이지로 이동
//	}
		return "Upload";
	}
	
	@RequestMapping(value = "song/uploadMusicCtr.do", method= { RequestMethod.POST })
	public String uploadMusicCtr(SongVO songVo, MultipartFile uploadSongFile
			, MultipartFile uploadSongImageFile )
	{
		logger.info("Welcome SongController! uploadMusicCtr \n uploadSongFile =" + uploadSongFile
				+ "\n uploadImageFile = " + uploadSongImageFile + "\n songVo =" + songVo);
		
		String uploadSongFolder = "C://upload//song";
		String uploadSongImageFolder = "C://upload//image";
		
//		파일 확장자 분리 (결과값 .xxx)
		String songFileType = uploadSongFile.getContentType();
		songFileType = "." + songFileType.split("/")[1];
		String songImageFileType = uploadSongImageFile.getContentType();
		songImageFileType = "." + songImageFileType.split("/")[1];
		logger.info("Stype = " + songFileType);
		logger.info("Stype = " + songImageFileType);
		
		String fullSongName = songVo.getSongName() + songFileType;
		String fullSongImageName = songVo.getAlbumName()  + songImageFileType;
//		
		File uploadSong = new File(uploadSongFolder, fullSongName);
		File uploadSongImage = new File(uploadSongImageFolder, fullSongImageName);
//		
		String songFullPath = uploadSongFolder + "//" + fullSongName;
		String songImageFullPath = uploadSongImageFolder + "//" + fullSongImageName;
		logger.info("SFP =" + songFullPath + "\n SIFP =" + songImageFullPath);
		
		songVo.setMusicResourcePath(songFullPath);
		songVo.setAlbumImagePath(songImageFullPath);
		
		logger.info("SFPVo =" + songVo.getMusicResourcePath());
		logger.info("SIFPVo =" + songVo.getAlbumImagePath()); 
//
		try {
			uploadSongFile.transferTo(uploadSong);
			uploadSongImageFile.transferTo(uploadSongImage);
			logger.info("upload complete!!");
			songService.addSong(songVo);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect:/uploadMusic.do";
	}
	
//	/* 음원 파일 업로드 */
//	@PostMapping("song/uploadSongAjaxAction.do")
//	public void uploadSongAjaxActionPOST(MultipartFile uploadSongFile) {
//		
//		logger.info("uploadSongAjaxActionPOST..........");
//		String uploadFolder = "C://upload";
//		
//		String uploadFileName = uploadSongFile.getOriginalFilename();
//		
//		
//		String uuid = UUID.randomUUID().toString();
//		
//		uploadFileName = uuid + "_" + uploadFileName;
//		File saveFile = new File(uploadFolder, uploadFileName);
//		
//		try {
//			uploadSongFile.transferTo(saveFile);
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
//	/* 앨범 이미지 파일 업로드 */
//	@PostMapping("song/uploadSongImageAjaxAction.do")
//	public void uploadSongImageAjaxActionPOST(MultipartFile uploadFile) {
//		
//		logger.info("uploadAjaxActionPOST..........");
//		logger.info("파일 이름 : " + uploadFile.getOriginalFilename());
//		logger.info("파일 타입 : " + uploadFile.getContentType());
//		logger.info("파일 크기 : " + uploadFile.getSize());
//	
//		
//	}
	
//	@RequestMapping(value = "song/DeleteMusicCtr.do", method=RequestMethod.GET)
//	public String deleteMusic(int songNo, HttpSession session)
//	{
//		if(session.getAttribute("MemberVo") != null)
//		{
//			MemberVo tempVo = (MemberVo)session.getAttribute("MemberVo");
//			if(tempVo.getAuth().equals("adminlister"))
//			{
//				songService.deleteMusicOne(songNo);
//			}
//		}
//		return "auth/authorityError"; // 그 외의 경우 권한이 없으므로 에러 페이지로 이동
//	}
	

}
