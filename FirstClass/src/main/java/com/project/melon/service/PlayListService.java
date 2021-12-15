package com.project.melon.service;

import com.project.melon.model.PlayListVO;

public interface PlayListService {
	
	public int playListInsertOne(PlayListVO playListVo);
	
	public void playListDeleteOne(int no);	
}
