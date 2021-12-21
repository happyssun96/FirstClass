package com.project.melon.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.melon.model.MelonVO;

@Repository
public class CrawlingDAOImpl implements CrawlingDAO{
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String nameSpace = "com.project.melon.";

	@Override
	public int MelonInsert(MelonVO melonVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + "melonInsert", melonVo);
	}

	@Override
	public void MelonDelete() {
		// TODO Auto-generated method stub
		sqlSession.delete(nameSpace + "melonDelete");
	}

}
