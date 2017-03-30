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
	
	 
	
	//로그인폼으로 가는 요청
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "/login";
	}
	
	//로그인폼에서 아이디, pw를 입력받아 로그인 요청
		@RequestMapping(value="/login", method=RequestMethod.POST)
		public String login(LibraryDto library, HttpSession session){
			libraryService.login(library);
			session.setAttribute("libraryId", libraryService.login(library).getLibraryId());
			System.out.println("세션확인 :"+session.getAttribute("libraryId"));
			return "/main";
		}
		
	//메인화면으로 감
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(){
		return "/main";
	}
	
	//library add폼으로 가는 요청
	@RequestMapping(value="/libraryadd" , method=RequestMethod.GET)
	public String add(Model model){
		logger.debug("add요청 get방식");
		List<LocalDto> local = libraryService.localNameSelect();
		logger.debug("local 확인 :"+local.toString());
		model.addAttribute("local", local);
		return "/library/libraryAddForm";
	}
	
	//library add폼에서 입력받아 도서관 관리자 가입처리
	@RequestMapping(value="/libraryadd", method=RequestMethod.POST)
	public String add(LibraryDto library){
		logger.debug("컨트롤러에서 library값 받았는지 확인 :"+library.toString());
		libraryService.libraryInsert(library);
		return "redirect:/login";
	}


	
	
}
