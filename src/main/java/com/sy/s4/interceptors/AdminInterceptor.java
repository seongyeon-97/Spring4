package com.sy.s4.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sy.s4.member.MemberDTO;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//관리자 꺼내오기
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		boolean result = false;
		if(memberDTO != null && memberDTO.getId().equals("t1")) {
			result = true;
		}else {
			//1. redirect
			//response.sendRedirect("../member/login");
			//2.forward
			request.setAttribute("msg", "관리자만 접근 가능한 권한입니다.");
			request.setAttribute("url", "../member/login");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return result;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Controller에서 return 후");
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("View 렌더링 후");
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("비동기요청시 PostHandle과 AfterCompletion 메서드를 수행하지 않고 이 메서드를 바로 실행");
	}
	
}
