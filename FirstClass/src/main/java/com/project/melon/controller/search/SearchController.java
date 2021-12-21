package com.project.melon.controller.search;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.melon.model.*;
import com.project.melon.service.*;

@Controller
@RequestMapping("/search")
public class SearchController {

	static final Logger log = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	SearchService service;
	
	/** searchMain(���հ˻�)
	 *  @param query
	 * */
	@RequestMapping(value="/searchMain", method=RequestMethod.GET)
	public void searchMain(@RequestParam("keyword") String queryText, Model model) throws Exception { 
		log.info("searchMain Controller .. ");
		
		List<SongVO> songVO = service.searchSong(queryText);
		
		//�˻���: null
		if(queryText.equals(null)){
			log.info("-----------------------");
			model.addAttribute("searchText", queryText);
		
		}else {
			model.addAttribute("searchText", queryText);
			
			//�� �˻� - 10��
			model.addAttribute("songList", songVO);
			model.addAttribute("songNum", songVO.size());
			
		}	
	}

	
}