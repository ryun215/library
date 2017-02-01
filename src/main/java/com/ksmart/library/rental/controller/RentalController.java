package com.ksmart.library.rental.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ksmart.library.HomeController;
import com.ksmart.library.dto.RentalDto;
import com.ksmart.library.dto.ReturnDto;
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
		
		return "redirect:/rental/rental";
		
	}
	//도서반납 폼으로 감
	@RequestMapping(value="/rental/return", method=RequestMethod.GET)
	public String bookReturn(){
		return "/library/rental/returnForm";
	}
	//도서반납폼에서 반납버튼 클릭
	@RequestMapping(value="/rental/return", method=RequestMethod.POST)
	public String bookReturn(ReturnDto bookReturn){
		rentalService.bookReturn(bookReturn);
		return "redirect:/rental/return";
	}
	
	//도서반납폼에서 도서코드 입력받음	
	@RequestMapping(value="/rental/getRentalInfo", method=RequestMethod.GET)
	public @ResponseBody ReturnDto getRentalInfo(@RequestParam("bookCode") String bookCode, HttpServletResponse response){
		logger.debug("북코드 확인 : "+bookCode);
		ReturnDto rentalInfo = rentalService.rentalInfoSelect(bookCode);
		System.out.println("rentalInfo : "+rentalInfo.toString());
		return rentalInfo;
		
	}
	
}
