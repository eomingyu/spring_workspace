package com.idev.bookrent.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idev.bookrent.mapper.BookrentMapper;

@RestController
public class ValidCheckRestController {
	private static final Logger logger = LoggerFactory.getLogger(ValidCheckRestController.class);
	
	@Autowired
	BookrentMapper mapper;
	@ResponseBody
	@RequestMapping(value="/asyncBook/{bcode}",method=RequestMethod.GET
			,produces = "application/json;charset=utf-8")
	public String getOne(@PathVariable String bcode) {
		int cnt = mapper.countByBcode(bcode);
		
		Map<String,Object> map = new HashMap<>();
		map.put("cnt",cnt);
		ObjectMapper objmapper = new ObjectMapper();
		String json_result=null;
		try {
			json_result = objmapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json_result;
	}
}
