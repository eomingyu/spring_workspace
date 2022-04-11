package com.koreait.idev.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.idev.mapper.ScheduleMapper;
import com.koreait.idev.model.Schedule;

@Controller
@RequestMapping("schedule/")
public class ScheduleController {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	
	@Autowired
	ScheduleMapper mapper;
	
	@GetMapping("/new.do")
	public String newdo(Model model) {
		List<Schedule> list = mapper.getSchedules();
		if(list!=null)
		model.addAttribute("list",list);
		return "schedule/schedule";
	}

	@PostMapping("/save")
	public String save(Schedule schedule) {
		mapper.insert(schedule);

		return "redirect:schedule/new.do";
	}
}