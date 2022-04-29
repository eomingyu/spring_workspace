package com.idev.bookrent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idev.bookrent.dto.BookRentDto;
import com.idev.bookrent.mapper.BookrentMapper;

@Controller
@RequestMapping("book/")
public class BookrentController {
	private static final Logger logger = LoggerFactory.getLogger(BookrentController.class);
	private final BookrentMapper mapper;
	
	public BookrentController(BookrentMapper mapper) {
		this.mapper=mapper;
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		logger.info(mapper.selectBooks().toString());
		model.addAttribute("list",mapper.selectBooks());
		return "book/bookList";
	}
	
	@GetMapping("rent")
	public String rent() {
		
		return "book/bookRent";
	}
	
	@PostMapping("rent")
	public String save(BookRentDto dto) {
		mapper.insertRent(dto);
		return "redirect:rentList";
	}
	
	@RequestMapping("rentList")
	public String return_(Model model) {
		mapper.updateDelays();
		model.addAttribute("list", mapper.getRentList());
		return "book/rentList";
	}
}
