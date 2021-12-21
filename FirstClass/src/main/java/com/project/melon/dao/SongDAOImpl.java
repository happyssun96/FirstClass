package com.project.melon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.melon.model.SongVO;

@Repository
public class SongDAOImpl implements SongDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String nameSpace = "com.project.melon.";
	
	@Override
	public void addSong(SongVO songVo) {
		// TODO Auto-generated method stub
		
		sqlSession.insert(nameSpace + "addSong", songVo);
	}

	@Override
	public List<SongVO> songSelectList(String keyword, int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		
		
		return sqlSession.selectList(nameSpace + "songSelectList", map);
	}

	@Override
	public int songSelectTotalCount() {
		return sqlSession.selectOne(nameSpace + "songSelectTotalCount");
	}

	@Override
	public void songDeleteOne(int songNo) {
		// TODO Auto-generated method stub
		sqlSession.delete(nameSpace + "songDeleteOne", songNo);
	}

	@Override
	public SongVO songSelectOne(int songNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + "songSelectOne", songNo);
	}

	@Override
	public void songUpdateOne(SongVO songVo) {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + "songUpdateOne", songVo);
		
	}

}
