package com.ksmart.library.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Intercepter extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("���ͼ��ͷ� ����");
		//���࿡ ���ǿ� libraryId�� ������ loginȭ������ �ٽ� ����
		System.out.println("������ �ִ��� Ȯ��"+request.getSession().getAttribute("libraryId"));
		if(request.getSession().getAttribute("libraryId")==null){
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}



}
