package com.project.melon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.melon.dao.SubscribeDAO;
import com.project.melon.model.SubscribeVO;

@Service
public class SubscribeServiceImpl implements SubscribeService{
	@Autowired
	public SubscribeDAO subscribeDao;

	@Override
	public int subscribeChk(SubscribeVO subscribeVo) {
		// TODO Auto-generated method stub
		return subscribeDao.subscribeChk(subscribeVo);
	}

	@Override
	public int subscribeInsertOne(int memberNo) {
		// TODO Auto-generated method stub
		return subscribeDao.subscribeInsertOne(memberNo);
	}

	@Override
	public SubscribeVO subscribeSelectOne(int memberNo) {
		// TODO Auto-generated method stub
		return subscribeDao.subscribeSelectOne(memberNo);
	}	
}
