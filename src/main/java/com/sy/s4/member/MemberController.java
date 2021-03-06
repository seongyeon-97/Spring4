package com.sy.s4.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("memberDelete")
	public String setDelete(MemberDTO memberDTO, HttpSession session) throws Exception{
		int result = memberService.setDelete(memberDTO);
		session.invalidate();
		return "redirect: ../";
	}
	
	@GetMapping("memberUpdate")
	public ModelAndView setUpdate(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberUpdate");
		mv.addObject("member", memberDTO);
		return mv;
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView setUpdate(MemberDTO memberDTO, ModelAndView mv, HttpSession session) throws Exception{
		int result = memberService.setUpdate(memberDTO);
		session.setAttribute("member", memberDTO);
		mv.setViewName("redirect: ../");
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView join(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception{
	
		ModelAndView mv = new ModelAndView();
		int result = memberService.setJoin(memberDTO, photo, session); 
		
		String message = "회원가입 실패";
		if(result>0) {
			message = "회원가입 성공";
		}
		mv.addObject("msg", message);
		mv.addObject("url", "../");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception{
		//사진 출력
		//세션에 담겨 있는 memberDOT에서 id를 받아 select 해서 사진 출력
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		MemberFilesDTO memberFilesDTO = memberService.getFile(memberDTO);
		
		
		ModelAndView mv = new ModelAndView();
		//mv.addObject("files", memberFilesDTO);
		mv.setViewName("member/mypage");		
		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) throws Exception{
		//1. session에 있는 어트리뷰트를 삭제
		//session.removeAttribute("member"); 
		//2. session의 시간을 0으로 만들기
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect: ../");
		return mv;
	}
	
	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception{
				
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getLogin(memberDTO);
		
		if(memberDTO != null) {
			System.out.println("로그인 성공");
			session.setAttribute("member", memberDTO);
		}else {			
			System.out.println("로그인 실패");
		}
		mv.addObject("dto", memberDTO);
		mv.setViewName("redirect: ../");
		
		return mv;
	}
	
	@GetMapping("login")
	public ModelAndView login() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}
	
	@GetMapping("idCheckAjax")
	public ModelAndView getIdCheckAjax(MemberDTO memberDTO) throws Exception{
		//중복검사할 id 출력
		System.out.println(memberDTO.getId());
		
		memberDTO = memberService.getIdCheck(memberDTO);
		int result = 0;
		
		if(memberDTO == null) {
			result = 1;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
		
	}
	
	@GetMapping("idCheck")
	public ModelAndView getIdCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getIdCheck(memberDTO);
		System.out.println("id 중복체크");		
		mv.setViewName("member/idCheck");
		mv.addObject("dto", memberDTO);
		return mv;
	}
	
	@GetMapping("check")
	public ModelAndView check() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/check");
		return mv;
	}
	
	@GetMapping("join")
	public ModelAndView join() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}
	
	
}
