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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.sy.s4.board.BoardDTO;
import com.sy.s4.board.BoardFilesDTO;
import com.sy.s4.board.CommentsDTO;
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
	
	@PostMapping("comment")
	public void setComment(CommentsDTO commentsDTO) throws Exception{
		System.out.println(commentsDTO.getWriter());
		System.out.println(commentsDTO.getContents());
		System.out.println(commentsDTO.getNum());
	}
	
	@GetMapping("down")
	public ModelAndView fileDown(BoardFilesDTO boardFilesDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardFilesDTO);
		mv.setViewName("fileDown");
		return mv;
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
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception{
		//original file name 출력
		for(MultipartFile multipartFile: files) {
			System.out.println(multipartFile.getOriginalFilename());
		}
		
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setInsert(boardDTO, files);
		mv.setViewName("redirect: ./list");
		
		return mv;
	}
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		List<BoardFilesDTO> ar = noticeService.getFiles(boardDTO);
		mv.addObject("dto", boardDTO);
		//mv.addObject("fileList", ar);
		mv.setViewName("board/select");
		return mv;
	}
	
	@RequestMapping("delete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setDelete(boardDTO);		
		ModelAndView mv = new ModelAndView();
		String message = "Delete fail";
		
		if(result>0) {
			message = "Delete Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("url", "./list");
		
		mv.setViewName("common/result");
		
		return mv;
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
