package com.ksmart.library.controller;

import java.util.List;

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
	
	
	@RequestMapping(value="/add" , method=RequestMethod.GET)
	public String add(Model model){
		logger.debug("add요청 get방식");
		List<LocalDto> local = libraryService.localNameSelect();
		logger.debug("local 확인 :"+local.toString());
		model.addAttribute("local", local);
	
		return "/libraryAddForm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(LibraryDto library){
		logger.debug("컨트롤러에서 library값 받았는지 확인 :"+library.toString());
		return "";
		
	}
}
