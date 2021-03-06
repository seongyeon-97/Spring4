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
	
	@GetMapping("getCommentList")
	public ModelAndView getCommentList(CommentsDTO commentsDTO, Pager pager) throws Exception{	
		commentsDTO.setBoard("N");
		List<CommentsDTO> ar = noticeService.getCommentList(commentsDTO, pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("comments", ar);
		mv.addObject("pager", pager);
		mv.setViewName("common/ajaxList");
		return mv;
	}
	
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
	
	/*
	 * @GetMapping("comment") public ModelAndView setComment() throws Exception{
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("board/select"); return
	 * mv; }
	 */
	
	@GetMapping("insert")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/insert");
		return mv;
	}
	
	@PostMapping("comment")
	public ModelAndView setComment(CommentsDTO commentsDTO) throws Exception{
		commentsDTO.setBoard("N");
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setComment(commentsDTO);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		System.out.println(commentsDTO.getCommentNum());
		System.out.println(commentsDTO.getNum());
		System.out.println(commentsDTO.getWriter());
		System.out.println(commentsDTO.getContents());
		System.out.println(commentsDTO.getRegdate());
		System.out.println(commentsDTO.getBoard());
		return mv;
//		mv.setViewName("redirect: ../");
	}
	
	@PostMapping("insert")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception{
		//original file name ??????
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
	
	/*
	 * @GetMapping("commentSelect") public ModelAndView getCommentSelect(CommentsDTO
	 * commentsDTO, HttpSession session)throws Exception{ ModelAndView mv = new
	 * ModelAndView(); commentsDTO = noticeService.getCommentSelect(commentsDTO);
	 * mv.addObject("comment", commentsDTO); mv.setViewName("board/commentSelect");
	 * return mv; }
	 */
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO, CommentsDTO commentsDTO) throws Exception{
		ModelAndView mv = new ModelAndView();

		boardDTO = noticeService.getSelect(boardDTO);			
		List<BoardFilesDTO> ar = noticeService.getFiles(boardDTO);
		//List<CommentsDTO> comments = noticeService.getCommentList();
		
		
		//commentsDTO = noticeService.getCommentSelect(commentsDTO);
		//mv.addObject("comment", commentsDTO);
		//mv.addObject("pager", pager);
		//mv.addObject("commentList", comments);
		mv.addObject("dto", boardDTO);
		//mv.addObject("fileList", ar);
		mv.setViewName("board/select");
		return mv;
	}
	
	@PostMapping("commentDel")
	   public ModelAndView setCommentDelete(CommentsDTO commentsDTO)throws Exception{
	      int result = noticeService.setCommentDelete(commentsDTO);
	      ModelAndView mv = new ModelAndView();
	      String message = "Delete Fail";
	      if(result>0) {
	         message="Delete Success";
	      }
	      mv.addObject("msg", message);
	      
	      
	      mv.setViewName("common/result");
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
	
	@PostMapping("commentUpdate")
	public ModelAndView setCommentUpdate(CommentsDTO commentsDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setCommentUpdate(commentsDTO);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
	}
	
	@PostMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFilesDTO boardFilesDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setFileDelete(boardFilesDTO);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
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
