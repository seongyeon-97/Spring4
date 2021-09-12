package com.sy.s4.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.sy.s4.board.BoardDTO;
import com.sy.s4.member.MemberDTO;
import com.sy.s4.member.MemberService;
import com.sy.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService; 
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("list")
	public ModelAndView getList(ModelAndView mv, Pager pager, MemberDTO memberDTO, HttpSession session) throws Exception{
		
		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@GetMapping("insert")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/insert");
		return mv;
	}
	
	@PostMapping("insert")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setInsert(boardDTO);
		mv.setViewName("redirect: ./list");
		
		return mv;
	}
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/select");
		return mv;
	}
	
	@RequestMapping("delete")
	public String setDelete(Long num) throws Exception{
		int result = noticeService.setDelete(num);
		return "redirect: ./list";
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		boardDTO = noticeService.getSelect(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/update");
		mv.addObject("dto", boardDTO);
		
		return mv;
	}
	
	
	@PostMapping("update")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		mv.setViewName("redirect: ./list");
		return mv;
	}
	
	
}
