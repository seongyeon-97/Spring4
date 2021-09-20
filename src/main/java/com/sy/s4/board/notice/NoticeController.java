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
	
	@GetMapping("comment")
	public ModelAndView setComment() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/select");
		return mv;
	}
	
	@GetMapping("insert")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/insert");
		return mv;
	}
	
	@PostMapping("comment")
	public void setComment(CommentsDTO commentsDTO) throws Exception{
		commentsDTO.setBoard("N");
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setComment(commentsDTO);
		System.out.println(commentsDTO.getCommentNum());
		System.out.println(commentsDTO.getNum());
		System.out.println(commentsDTO.getWriter());
		System.out.println(commentsDTO.getContents());
		System.out.println(commentsDTO.getRegdate());
		System.out.println(commentsDTO.getBoard());
		mv.setViewName("redirect: ./select");
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
	
	/*
	 * @RequestMapping("select") public ModelAndView getCommentList() throws
	 * Exception{ ModelAndView mv = new ModelAndView();
	 * mv.setViewName("board/select"); List<CommentsDTO> ar =
	 * noticeService.getCommentList(); mv.addObject("commentList", ar);
	 * System.out.println(ar.get(0).getCommentNum()); return mv; }
	 */
	
	@GetMapping("commentSelect")
	public ModelAndView getCommentSelect(CommentsDTO commentsDTO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		commentsDTO = noticeService.getCommentSelect(commentsDTO);
		mv.addObject("comment", commentsDTO);
		mv.setViewName("board/commentSelect");
		return mv;
	}
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO, Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<CommentsDTO> car = noticeService.getCommentList(pager);
		boardDTO = noticeService.getSelect(boardDTO);			
		List<BoardFilesDTO> ar = noticeService.getFiles(boardDTO);
		System.out.println(car.get(0).getCommentNum());
		mv.addObject("pager", pager);
		mv.addObject("commentList", car);
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
