package com.project.melon.service;

import java.util.List;

import com.project.melon.model.SongVO;

public interface SongService {
	
	public void addSong(SongVO songVo);
	public List<SongVO> songSelectList(String keyword, int start, int end);	
	public int songSelectTotalCount();
	public void songDeleteOne(int songNo);
	public SongVO songSelectOne(int songNo);
	public void songUpdateOne(SongVO songVo);
}
