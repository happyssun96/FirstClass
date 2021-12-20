package com.project.melon.dao;

import com.project.melon.model.SubscribeVO;

public interface SubscribeDAO {

	//구독권 중복체크
	public int subscribeChk(SubscribeVO subscribeVo);
	
	//구독권 추가
	public int subscribeInsertOne(SubscribeVO subscribeVo);
}
