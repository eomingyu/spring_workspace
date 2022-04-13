package com.mycompany.idev.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.idev.dto.Freeboard;
import com.mycompany.idev.dto.PageDto;
import com.mycompany.idev.mapper.FreeboardMapper;

@Controller
@RequestMapping("/community")
public class FreeboardController {
	private static final Logger logger = 
			LoggerFactory.getLogger(FreeboardController.class);
	
	@Autowired
	FreeboardMapper mapper;
	
	@RequestMapping("/list")
	public String list(@RequestParam(required=false, defaultValue = "1")
						int pageNo,Model model) {
		PageDto page = new PageDto(pageNo,10,mapper.getCount());
		
		Map<String,Integer> map = new HashMap<>();
		map.put("startNo", page.getStartNo());
		map.put("endNo", page.getEndNo());
		List<Freeboard> list = mapper.getPageList(map);
		
		model.addAttribute("page",page);
		model.addAttribute("list",list);
		
		return "community/list";
	}
	
	
}