package com.ksmart.library.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Intercepter extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("인터셉터로 들어옴");
		//만약에 세션에 libraryId가 없으면 login화면으로 다시 보냄
		System.out.println("세션이 있는지 확인"+request.getSession().getAttribute("libraryId"));
		if(request.getSession().getAttribute("libraryId")==null){
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}



}
