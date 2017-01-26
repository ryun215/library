package com.ksmart.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ksmart.library.dto.LocalDto;
import com.ksmart.library.service.LibraryService;

@Controller
public class LibraryController {
	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
	@Autowired
	private LibraryService libraryService;
	
	
	@RequestMapping(value="/add" , method=RequestMethod.GET)
	public String add(Model model){
		logger.debug("add요청 get방식");
		List<LocalDto> local = libraryService.localNameSelect();
		logger.debug("local 확인 :"+local.toString());
		model.addAttribute("local", local);
	
		return "/libraryAddForm";
	}
	
	public String add(){
		
		return null;
		
	}
}
