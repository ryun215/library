package com.ksmart.library.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ksmart.library.dto.LibraryDto;
import com.ksmart.library.dto.LocalDto;
import com.ksmart.library.service.LibraryService;

@Controller
public class LibraryController {
	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
	@Autowired
	private LibraryService libraryService;
	
	 
	
	//�α��������� ���� ��û
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "/login";
	}
	
	//�α��������� ���̵�, pw�� �Է¹޾� �α��� ��û
		@RequestMapping(value="/login", method=RequestMethod.POST)
		public String login(LibraryDto library, HttpSession session){
			libraryService.login(library);
			session.setAttribute("libraryId", libraryService.login(library).getLibraryId());
			System.out.println("����Ȯ�� :"+session.getAttribute("libraryId"));
			return "/main";
		}
		
	//����ȭ������ ��
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(){
		return "/main";
	}
	
	//library add������ ���� ��û
	@RequestMapping(value="/libraryadd" , method=RequestMethod.GET)
	public String add(Model model){
		logger.debug("add��û get���");
		List<LocalDto> local = libraryService.localNameSelect();
		logger.debug("local Ȯ�� :"+local.toString());
		model.addAttribute("local", local);
		return "/library/libraryAddForm";
	}
	
	//library add������ �Է¹޾� ������ ������ ����ó��
	@RequestMapping(value="/libraryadd", method=RequestMethod.POST)
	public String add(LibraryDto library){
		logger.debug("��Ʈ�ѷ����� library�� �޾Ҵ��� Ȯ�� :"+library.toString());
		libraryService.libraryInsert(library);
		return "redirect:/login";
	}


	
	
}
