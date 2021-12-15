package com.project.melon.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.melon.model.PlayListVO;

public class PlayListDAOImpl implements PlayListDAO{

	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String nameSpace = "com.project.melon.";
	
	@Override
	public int playListInsertOne(PlayListVO playListVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + "playListInsertOne", playListVo);
	}

	@Override
	public void playListDeleteOne(int no) {
		// TODO Auto-generated method stub
		sqlSession.delete(nameSpace + "playListDeleteOne", no);
	}

}
