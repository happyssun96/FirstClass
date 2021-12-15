package com.project.melon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.melon.dao.SongDao;
import com.project.melon.model.SongVo;

@Service
public class SongServiceImpl implements SongService{

	@Autowired
	public SongDao songDao;
	
	@Override
	public void addSong(SongVo songVo) {
		
		songDao.addSong(songVo);
		
	}

	@Override
	public List<SongVo> songSelectList(String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return songDao.songSelectList(keyword, start, end);
	}


}
