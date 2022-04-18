package com.mycompany.idev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.idev.dto.Administrator;
import com.mycompany.idev.dto.Member;


@Controller
//@SessionAttributes({"user","admin"})	//다른 컨트롤러 jsp에서 사용할 때 //model.atrribute로 세션에 사용할 때
public class TestLoginController {
	private static final Logger logger = LoggerFactory.getLogger(TestLoginController.class);
	
	//로그인과 같은 동작을 하는 테스트용입니다. (post 방식이어야 합니다.)
	@RequestMapping("login")
		public String login(HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.setAttribute("member", new Member(0, "모모", null, "momo@naver.com"));
			
			return "redirect:/";
	}
	
	@RequestMapping("admin")	//관리자 로그인
	public String admin(HttpSession session) {
		session.setAttribute("admin", new Administrator("root",1));
		
		return "redirect:/";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
}
