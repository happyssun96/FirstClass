package com.project.melon.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.melon.model.*;


@Repository
public class SearchDAOImpl implements SearchDAO{

	static private Logger log = LoggerFactory.getLogger(SearchDAOImpl.class);
	private String namespace ="com.project.melon.";
	
	@Autowired
	SqlSession session;	

	@Override
	public List<SongVO> searchSong(String searchText) throws Exception {
		return session.selectList(namespace+"searchSong", searchText);
	}

}
