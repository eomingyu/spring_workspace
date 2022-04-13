package com.koreait.idev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.koreait.idev.mapper.ScheduleMapper;
import com.koreait.idev.model.Member;
import com.koreait.idev.model.Schedule;

@Controller
@RequestMapping("schedule/")
@SessionAttributes("member")
public class ScheduleController {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	
	@Autowired
	ScheduleMapper mapper;
	
	@GetMapping("/new.do")
	public String newdo(Model model,
			@SessionAttribute(value="member", required = false) Member member) {
		//로그인 상태가 아닐 때 : 400 오류(Missing sessrion attribute 'member' of type Member)
		//-> @SessionAttribute에 대해 필수적인 값 false로 설정
		model.addAttribute("list",mapper.getSchedules(member.getMno()));
		return "schedule/schedule";
	}

	@GetMapping("/save.do")
	public String save(Schedule sch, Model model) throws ParseException {
		String sdate = sch.getSdate() + " " + sch.getStime();
	logger.info("[My]"+sdate);
		sch.setSdate(sdate);
		mapper.insert(sch);

		return "redirect:new.do";
	}
	@GetMapping("/delete.do")
	public void delete(int idx,@SessionAttribute(value="member",required=false) Member member,
			HttpServletResponse response) throws IOException {
		String message;
		//로그인 상태가 아닐 때 member는 null
		if(member!=null && mapper.checkMno(idx)==member.getMno()) {
			message="삭제하였습니다.";
			mapper.delete(idx);
		}else {
			message="삭제 오류입니다.";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String url="./new.do";
		out.print("<script>alert('"+message+"');location.href='"+url+"'");
		out.print("</script>");
	}
	
}