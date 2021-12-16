package com.project.melon.dao;

import com.project.melon.model.PlayListVO;

public interface PlayListDAO {
	
	public int playListInsertOne(PlayListVO playListVo);
	
	public void playListDeleteOne(int no);
}