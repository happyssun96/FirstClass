package com.project.melon.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.melon.dao.SearchDAO;
import com.project.melon.model.SongVO;

@Service
public class SearchServiceImpl implements SearchService{

	static final Logger log = LoggerFactory.getLogger(SearchServiceImpl.class);
	
	@Autowired
	SearchDAO dao;

	@Override
	public List<SongVO> searchSong(String searchText) throws Exception {
		return dao.searchSong(searchText);
	}


}
