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
	public List<MemberVO> memberSelectList(String keyword, int start, int end) {
		// TODO Auto-generated method stub
	
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
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

	@Override
	public int emailChk(MemberVO memberVo) {
		// TODO Auto-generated method stub
		
		//중복된 이메일이 있으면 1 없으면 0
		int resultEmail = sqlSession.selectOne(nameSpace + "emailChk", memberVo);
		
		return resultEmail;
	}

	@Override
	public int nickNameChk(MemberVO memberVo) {
		// TODO Auto-generated method stub
		
		//중복된 닉네임이 있으면 1 없으면 0
		int resultNickName = sqlSession.selectOne(nameSpace + "nickNameChk", memberVo);
		
		return resultNickName;
	}

	@Override
	public int memberInsertOne(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + "memberInsertOne", memberVo);
	}

	@Override
	public int memberSelectTotalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + "memberSelectTotalCount");
	}

	@Override
	public MemberVO memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + "memberSelectOne", no);
	}

	@Override
	public int memberUpdateOne(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + "memberUpdateOne", memberVo);
	}

	@Override
	public void memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		sqlSession.delete(nameSpace + "memberDeleteOne", no);
	}
	
	
	
	
}