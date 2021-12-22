package com.project.melon.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.melon.model.SubscribeVO;

@Repository
public class SubscribeDAOImpl implements SubscribeDAO{
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String nameSpace = "com.project.melon.";
	@Override
	public int subscribeChk(SubscribeVO subscribeVo) {
		// TODO Auto-generated method stub
		int resultSubscribeChk = sqlSession.selectOne(nameSpace + "subscribeChk", subscribeVo);
		
		return resultSubscribeChk;
	}
	@Override
	public int subscribeInsertOne(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + "subscribeInsertOne", memberNo);
	}
	@Override
	public SubscribeVO subscribeSelectOne(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + "subscribeSelectOne", memberNo);
	}

}
