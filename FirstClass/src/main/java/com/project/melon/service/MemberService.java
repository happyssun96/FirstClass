package com.project.melon.service;

import java.util.List;

import com.project.melon.model.MemberVO;

public interface MemberService {
	
	public List<MemberVO> memberSelectList(String keyword, int start, int end);
	
	public MemberVO memberExist(String email, String password);	
	
	//이메일 중복체크
	public int emailChk(MemberVO memberVo);
	
	//닉네임 중복체크
	public int nickNameChk(MemberVO memberVo);
	
	public int memberInsertOne(MemberVO memberVo);
	
	public int memberSelectTotalCount();
	
	public MemberVO memberSelectOne(int no);
	
	public int memberUpdateOne(MemberVO memberVo);
	
	public void memberDeleteOne(int no);
}