package com.project.melon.dao;

import java.util.List;

import com.project.melon.model.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> memberSelectList(String searchOption, String keyword, int start, int end);
	
	public MemberVO memberExist(String email, String password);
}
