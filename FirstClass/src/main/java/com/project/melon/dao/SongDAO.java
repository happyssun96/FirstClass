package com.project.melon.dao;

import java.util.List;

import com.project.melon.model.SongVO;

public interface SongDAO {
	
	public void addSong(SongVO songVo);
	public List<SongVO> songSelectList(String keyword, int start, int end);		
	public int songSelectTotalCount(String keyword);
}
