package com.project.melon.service;

import java.util.List;

import com.project.melon.model.*;

public interface SearchService {

	List<SongVO> searchSong(String searchText) throws Exception;  //search song in searchMain.jsp
		

}
