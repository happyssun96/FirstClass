package com.project.melon.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseListDAOImpl implements PurchaseListDAO{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String nameSpace = "com.project.melon.";

	
	@Override
	public void addPurchaseList(int memberNo, int subscribeNo) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("purchaseNo", memberNo);
		map.put("purchaseUserNo", subscribeNo);
		
		sqlSession.insert(nameSpace + "addPurchaseList", map);
		
	}

}
