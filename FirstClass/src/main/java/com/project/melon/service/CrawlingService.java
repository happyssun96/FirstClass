package com.project.melon.service;

import com.project.melon.model.MelonVO;

public interface CrawlingService {

	public int MelonInsert(MelonVO melonVo); 
	
	public void MelonDelete();
}
