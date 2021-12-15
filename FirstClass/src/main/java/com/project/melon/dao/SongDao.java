package com.project.melon.dao;

import java.util.List;

import com.project.melon.model.SongVo;

public interface SongDao {
	
	public void addSong(SongVo songVo);
	public List<SongVo> songSelectList(String keyword, int start, int end);
}
