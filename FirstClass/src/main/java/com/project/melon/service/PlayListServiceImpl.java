package com.project.melon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.melon.dao.PlayListDAO;
import com.project.melon.model.PlayListVO;


@Service
public class PlayListServiceImpl implements PlayListService{
	@Autowired
	public PlayListDAO playListDAO;
	
	@Override
	public int playListInsertOne(PlayListVO playListVo) {
		// TODO Auto-generated method stub
		return playListDAO.playListInsertOne(playListVo);
	}

	@Override
	public void playListDeleteOne(int no) {
		// TODO Auto-generated method stub
		playListDAO.playListDeleteOne(no);
	}

}
