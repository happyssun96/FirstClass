package com.project.melon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.melon.dao.MemberDAO;
import com.project.melon.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	public MemberDAO memberDao;
	
	@Override
	public List<MemberVO> memberSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectList(searchOption, keyword, start, end);
	}

	@Override
	public MemberVO memberExist(String email, String password) {
		// TODO Auto-generated method stub
		return memberDao.memberExist(email, password);
	}
	
	
	
	
	
}
