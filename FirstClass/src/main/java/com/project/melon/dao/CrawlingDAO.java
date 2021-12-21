package com.project.melon.dao;

import com.project.melon.model.MelonVO;

public interface CrawlingDAO {
	
	public int MelonInsert(MelonVO melonVo); 
	
	public void MelonDelete();
}
