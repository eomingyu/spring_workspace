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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@PostMapping("/insert") 	//글 쓰기 -> 완료 alert
	public String save(Freeboard dto, RedirectAttributes rda) {
		mapper.insert(dto);
		rda.addFlashAttribute("message", "글쓰기가 완료되었습니다.");
		//list.jsp로 바로 전달됩니다. 특징 : url에 표시되지 않습니다.(model은 url에 보입니다.)
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
	@PostMapping("update")	//글 수정 -> 완료 alert
//	public String update(Freeboard vo, int pageNo, Model model,
	public String update(Freeboard vo, int pageNo,
			RedirectAttributes rda) {
		
		mapper.update(vo);
//		model.addAttribute("idx", vo.getIdx());
//		model.addAttribute("pageNo", pageNo);
		rda.addAttribute("idx", vo.getIdx());
		rda.addAttribute("pageNo", pageNo);
	//	model.addAttribute("message","글 수정 완료되었습니다.");
	//	-> 대신에 사용하는 RedirectAttributes addFlashAttribute() 메소드로 값을 전달
		rda.addFlashAttribute("message", "글 수정 완료되었습니다.");
		return "redirect:detail";
		// rda 애트리뷰트는 url의 view(detail.jsp) 까지 바로 전달
		//중요 : RedirectAttributes는 Model과는 충돌됩니다.
		//		:@PostMapping이고 redirect에서만 사용합니다.
	}
	
	@PostMapping("delete")	//글 삭제 -> 완료 alert
	public String deleteFreeboard(int idx,int pageNo,RedirectAttributes rda) {
		
		mapper.delete(idx);
		rda.addAttribute("pageNo", pageNo);
		rda.addFlashAttribute("message", "글이 삭제되었습니다.");
		return "redirect:list";
	}
	
//	@GetMapping("delete")	//글 삭제 -> 완료 alert
//	public String deleteFreeboard(int idx,int pageNo,Model model) {
//	mapper.delete(idx);
//	model.addAttribute("pageNo", pageNo);
//	return "redirect:list";
//}
	
	
	
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