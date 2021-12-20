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
	public List<MemberVO> memberSelectList(String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectList(keyword, start, end);
	}

	@Override
	public MemberVO memberExist(String email, String password) {
		// TODO Auto-generated method stub
		return memberDao.memberExist(email, password);
	}

	@Override
	public int emailChk(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return memberDao.emailChk(memberVo);
	}

	@Override
	public int nickNameChk(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return memberDao.nickNameChk(memberVo);
	}

	@Override
	public int memberInsertOne(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return memberDao.memberInsertOne(memberVo);
	}


	@Override
	public int memberSelectTotalCount() {
		// TODO Auto-generated method stub
		return memberDao.memberSelectTotalCount();
	}

	@Override
	public MemberVO memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectOne(no);
	}

	@Override
	public int memberUpdateOne(MemberVO memberVo) {
		// TODO Auto-generated method stub
		return memberDao.memberUpdateOne(memberVo);
	}

	@Override
	public void memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		memberDao.memberDeleteOne(no);
	}

	@Override
	public void memberPurchaseCash(int no, int chosenCash) {
		// TODO Auto-generated method stub
		memberDao.memberPurchaseCash(no, chosenCash);
	}

	
	
	
	
	
}