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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.koreait.idev.mapper.MemberMapper;
import com.koreait.idev.model.Member;

@Controller
@SessionAttributes("member")
@RequestMapping(value = "member/")
public class MemberController {
private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberMapper mapper;	//dao 역할.의존관계 주입

	@GetMapping("/list.do")
	public String list(Model model) {	//매개변수로 선언된 Model 객체를 이용하여 
										//지정된 view(또는 redirect url)로 데이터를 전달합니다.
		List<Member> list = mapper.selectAll();
		model.addAttribute("list", list);
		return "member/MemberList";
	}
	
	@GetMapping("/join.do")
	public String join() {
		return "member/MemberForm";
	}
	
	@PostMapping("/join.do")
	public String insert(Member member) {	//폼 입력된 값의 name 속성과 Member 객체가 매핑되어 데이터가 저장됩니다.
		
		logger.info("[My]"+member);
		mapper.addMember(member);
		return "redirect:../";
	}
	
	@GetMapping("/update.do")
	public String update() {
		return "member/MemberUpdateForm";
	}
	
	@PostMapping("/save.do")
	public String save(Member member, Model model) {
		logger.info("[My]"+member);
		mapper.updateMember(member);
		//model.addAttribute("member",member);
		return "redirect:update.do";
	}
	
	@GetMapping("/idCheck.do")
	public String idCheck(String email, Model model) {
		String msg;
		int check = mapper.checkEmail(email);
		if(check==0) {
			msg = "사용할수 있는 이메일(아이디)입니다.";
			model.addAttribute("msg",msg);
		}else {
			msg = "사용할수 없는 이메일(아이디)입니다.";
			model.addAttribute("msg",msg);
		}
		model.addAttribute("email",email);
		
		
		return "member/idCheck";
	}
}
