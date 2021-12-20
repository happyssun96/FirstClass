package com.project.melon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.melon.dao.PurchaseListDAO;

@Service
public class PurchaseListServiceImpl implements PurchaseListService{

	@Autowired
	public PurchaseListDAO purchaseListDao;
	
	
	@Override
	public void addPurchaseList(int memberNo, int subscribeNo) {
		// TODO Auto-generated method stub
		purchaseListDao.addPurchaseList(memberNo, subscribeNo);		
	}

}
