package com.ksmart.library.rental.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ksmart.library.HomeController;
import com.ksmart.library.dto.RentalDto;
import com.ksmart.library.rental.service.RentalService;

@Controller
public class RentalController {
	private static final Logger logger = LoggerFactory.getLogger(RentalController.class);
	@Autowired
	private RentalService rentalService;
	
	
	//도서대여폼으로 감
	@RequestMapping(value="/rental/rental", method=RequestMethod.GET)
	public String rental(){
		return "/library/rental/rentalForm";
	}
	
	//도서대여폼에서 정보입력
	@RequestMapping(value="/rental/rental", method=RequestMethod.POST)
	public String rental(RentalDto rental){
		logger.debug("도서정보 입력받아 submit 컨트롤러");
		logger.debug("rental확인 "+rental.toString());
		rentalService.bookStateSelectAndRental(rental);
		
		return "";
		
	}
	//도서반납 폼으로 감
	@RequestMapping(value="/rental/return", method=RequestMethod.GET)
	public String bookReturn(){
		return "/library/rental/returnForm";
	}
	
	//도서반납폼에서 도서코드 입력받음
	@RequestMapping(value="/rental/return", method=RequestMethod.POST)
	public String bookReturn(RentalDto rental){
		return "";
		
	}
	
}
