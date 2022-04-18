package com.koreait.idev.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.idev.model.Gallery;
import com.koreait.idev.service.GalleryService;

@Controller
public class GalleryController {
	private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);
	//@Autowired -> 의존성 주입을 순환하는 오류가 쉽게 발생될 수 있다.
	private final GalleryService service;
	//생성자로 자동주입합니다.
	public GalleryController(GalleryService service) {
		this.service=service;
	}
	
	@RequestMapping(value="gallery", method=RequestMethod.GET)
	public void insert(Model model) {
		List<Gallery> list = service.getList();
		model.addAttribute("list",list);
	}
	
	@RequestMapping(value="gallery",method=RequestMethod.POST)
	//		,headers = ("content-type=multipart/*"))
	public String save(Gallery vo) { 
		try {
			service.save(vo);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} 
		return "redirect:gallery";
	}
	
	
}
