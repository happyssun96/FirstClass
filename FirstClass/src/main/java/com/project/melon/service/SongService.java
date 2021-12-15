package com.project.melon.service;

import java.util.List;

import com.project.melon.model.SongVo;

public interface SongService {
	
	public void addSong(SongVo songVo);
	public List<SongVo> songSelectList(String keyword, int start, int end);	
}
