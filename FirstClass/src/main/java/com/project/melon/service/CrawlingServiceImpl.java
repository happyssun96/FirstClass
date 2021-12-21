package com.project.melon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.melon.dao.CrawlingDAO;
import com.project.melon.model.MelonVO;

@Service
public class CrawlingServiceImpl implements CrawlingService{
	
	@Autowired
	public CrawlingDAO crawlingDao;
	
	@Override
	public int MelonInsert(MelonVO melonVo) {
		// TODO Auto-generated method stub
		return crawlingDao.MelonInsert(melonVo);
	}

	@Override
	public void MelonDelete() {
		// TODO Auto-generated method stub
		crawlingDao.MelonDelete();
	}

}
