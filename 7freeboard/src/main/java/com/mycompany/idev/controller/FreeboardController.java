package com.mycompany.idev.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.idev.dto.Comments;
import com.mycompany.idev.dto.Freeboard;
import com.mycompany.idev.dto.PageDto;
import com.mycompany.idev.mapper.CommentMapper;
import com.mycompany.idev.mapper.FreeboardMapper;

@Controller
@RequestMapping("/community")
public class FreeboardController {
	private static final Logger logger = 
			LoggerFactory.getLogger(FreeboardController.class);
	
	@Autowired
	FreeboardMapper mapper;
	
	@Autowired
	CommentMapper cmt_mapper;
	
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
		//return "community/list2";	//pageNo를 form data로 전달하는 예시
		
	}
	@GetMapping("/insert")
	public String insert(int pageNo, Model model) {
		model.addAttribute("page",pageNo);
		
		return "community/insert";
	}
	@PostMapping("/insert")
	public String save(Freeboard dto) {
		mapper.insert(dto);
		return "redirect:list";	//1페이지로 이동
	}
	@GetMapping("/detail")
	public String detail(int idx, int pageNo, Model model) {
		//조회수 증가 먼저
		mapper.readCount(idx);
		Freeboard bean = mapper.getOne(idx);
		model.addAttribute("bean",bean);
		model.addAttribute("page",pageNo);
		
		//댓글 목록을 detail.jsp에 출력
		List<Comments> cmtlist = cmt_mapper.list(idx);
		model.addAttribute("cmtlist", cmtlist);
		
		return "community/detail";
	}
	@PostMapping("update")
	public String update(Freeboard vo, int pageNo, Model model) {
		
		mapper.update(vo);
		model.addAttribute("idx", vo.getIdx());
		model.addAttribute("pageNo", pageNo);
		
		return "redirect:detail";
	}
	
	@GetMapping("delete")
	public String deleteFreeboard(int idx,int pageNo,Model model) {
		
		mapper.delete(idx);
		model.addAttribute("pageNo", pageNo);
		return "redirect:list";
	}
	
	
	
	// 여기서 부터는 댓글 처리
	@Transactional
	@PostMapping("comment")
	public String comment_save(Comments dto,int pageNo,Model model) {
		//댓글 입력 요소 값들 db에 저장 -> detail(글 상세보기)
		cmt_mapper.insert(dto);
		//mref값이 freeboard 테이블의 idx입니다.
		cmt_mapper.commentCountUp(dto.getMref());
		//idx는 시퀀스 값으로 지금 없는 상태입니다.
		model.addAttribute("idx",dto.getMref()); 
		model.addAttribute("pageNo",pageNo);
		return "redirect:detail";	//위에 detail()로 넘어간다  
	}
	@Transactional
	@GetMapping("comment")  //idx: 댓글 idx , mref:메인글 idx
	public String delete(int idx,int pageNo,int mref,Model model) {
		cmt_mapper.delete(idx);
		cmt_mapper.commentCountDown(mref);
		model.addAttribute("idx",mref );  //메인글의 idx값 전달
		model.addAttribute("pageNo", pageNo);
		return "redirect:detail";
	}
}