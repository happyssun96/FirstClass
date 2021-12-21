package com.project.melon.dao;

import java.util.List;

import com.project.melon.model.*;


public interface SearchDAO {

	List<SongVO> searchSong(String searchText) throws Exception;	//��

}
