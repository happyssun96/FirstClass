package com.project.melon.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.melon.model.PurchaseListVO;
import com.project.melon.model.SubscribeVO;

@Repository
public class PurchaseListDAOImpl implements PurchaseListDAO{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String nameSpace = "com.project.melon.";

	
	@Override
	public void addPurchaseList(SubscribeVO subscribeVo) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("memberNo", subscribeVo.getMember_no());
		map.put("subscribeNo", subscribeVo.getSubscribe_no());
		
		sqlSession.insert(nameSpace + "addPurchaseList", map);
		
	}

}
