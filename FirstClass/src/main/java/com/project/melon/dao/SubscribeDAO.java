package com.project.melon.dao;

import com.project.melon.model.MemberVO;
import com.project.melon.model.SubscribeVO;

public interface SubscribeDAO {

	//구독권 중복체크
	public int subscribeChk(int memberNo);
	
	//구독권 추가
	public int subscribeInsertOne(int memberNo);
	
	public SubscribeVO subscribeSelectOne(int memberNo);
}
