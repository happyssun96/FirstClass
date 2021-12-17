package com.project.melon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.melon.dao.SongDAO;
import com.project.melon.model.SongVO;

@Service
public class SongServiceImpl implements SongService{

	@Autowired
	public SongDAO songDao;
	
	@Override
	public void addSong(SongVO songVo) {
		
		songDao.addSong(songVo);
		
	}

	@Override
	public List<SongVO> songSelectList(String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return songDao.songSelectList(keyword, start, end);
	}

	@Override
	public int songSelectTotalCount(String keyword) {
		return songDao.songSelectTotalCount(keyword);
	}


}
