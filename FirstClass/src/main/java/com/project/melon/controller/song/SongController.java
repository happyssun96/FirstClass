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
	
	@RequestMapping(value = "uploadMusic.do", method=RequestMethod.GET)
	public String uploadMusic(HttpSession session, Model model)
	{
		logger.info("Welcome SongController! uploadMusic");
		
		String viewUrl = "./auth/authorityError";
		
		if(session.getAttribute("member") != null)
		{
			MemberVO tempVo = (MemberVO)session.getAttribute("member");
			if(tempVo.getAuth().equals("admin"))
			{
				viewUrl = "songUploadForm"; // 어드민 계정검증이 완료되었으므로 음악 업로드 폼으로 이동
			}
		}
		return viewUrl; // 그 외의 경우 권한이 없으므로 에러 페이지로 이동
		
	}
	
	@RequestMapping(value = "uploadMusicCtr.do", method= { RequestMethod.POST })
	public String uploadMusicCtr(SongVO songVo, MultipartFile uploadSongFile
			, MultipartFile uploadSongImageFile )
	{
		logger.info("Welcome SongController! uploadMusicCtr \n uploadSongFile =" + uploadSongFile
				+ "\n uploadImageFile = " + uploadSongImageFile + "\n songVo =" + songVo);
		
		
		
		String viewUrl = "redirect:./adminSongSearchPage.do";
		
		String uploadSongFolder = "C:\\gitRepository\\WaterMelon\\FirstClass\\src\\main\\webapp\\resources\\songs";
		String uploadSongImageFolder = "C:\\gitRepository\\WaterMelon\\FirstClass\\src\\main\\webapp\\resources\\images\\covers";
		
		
		String fullSongName = uploadSongFile.getOriginalFilename();
		String fullSongImageName = uploadSongImageFile.getOriginalFilename();

		File uploadSong = new File(uploadSongFolder, fullSongName);
		
		File uploadSongImage = new File(uploadSongImageFolder, fullSongImageName);
		String songFullPath = "resources/songs/" + fullSongName;
		String songImageFullPath = "resources/images/covers/" + fullSongImageName;
		
		songVo.setMusicResourcePath(songFullPath);
		songVo.setAlbumImagePath(songImageFullPath);
		
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
		
		
		return viewUrl;
	}
	
	@RequestMapping(value = "DeleteMusicCtr.do", method=RequestMethod.GET)
	public String deleteMusic(int songNo, HttpSession session)
	{
		String viewUrl = "authorityError";
		if(session.getAttribute("member") != null)
		{
			MemberVO tempVo = (MemberVO)session.getAttribute("member");
			if(tempVo.getAuth().equals("adminlister"))
			{
				SongVO songTempVo = songService.songSelectOne(songNo);
				
				String deleteMusicResourcePath = songTempVo.getMusicResourcePath();
				String deleteAlbumImagePath = songTempVo.getAlbumImagePath();
				
				File songFile = new File(deleteMusicResourcePath);
				File imageFile = new File(deleteAlbumImagePath);
				
				songFile.delete();
				imageFile.delete();
				
				songService.songDeleteOne(songNo);
				viewUrl = "redirect :/adminMainPage.do";;
				}
				
			}
		return viewUrl; 
	}
	

}
