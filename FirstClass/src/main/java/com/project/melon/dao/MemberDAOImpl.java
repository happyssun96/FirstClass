package com.project.melon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.melon.model.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String nameSpace = "com.project.melon.";

	@Override
	public List<MemberVO> memberSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
	
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("searchOption", searchOption);
		map.put("start", start);
		map.put("end", end);
		
		
		return sqlSession.selectList(nameSpace + "memberSelectList", map);
	}

	@Override
	public MemberVO memberExist(String email, String password) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("email", email);
		paramMap.put("password", password);
		
		return sqlSession.selectOne(nameSpace + "memberExist", paramMap);
	}
	
	
	
	
}
