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
	
	
	//�����뿩������ ��
	@RequestMapping(value="/rental/rental", method=RequestMethod.GET)
	public String rental(){
		return "/library/rental/rentalForm";
	}
	
	//�����뿩������ �����Է�
	@RequestMapping(value="/rental/rental", method=RequestMethod.POST)
	public String rental(RentalDto rental){
		logger.debug("�������� �Է¹޾� submit ��Ʈ�ѷ�");
		logger.debug("rentalȮ�� "+rental.toString());
		rentalService.bookStateSelectAndRental(rental);
		
		return "redirect:/rental/rental";
		
	}
	//�����ݳ� ������ ��
	@RequestMapping(value="/rental/return", method=RequestMethod.GET)
	public String bookReturn(){
		return "/library/rental/returnForm";
	}
	
	//�����ݳ������� �����ڵ� �Է¹���
	@RequestMapping(value="/rental/return", method=RequestMethod.POST)
	public String bookReturn(RentalDto rental){
		rentalService.rentalInfoSelect(rental);
		return "";
	}
	
	@RequestMapping(value="/rental/rentalInfo", method=RequestMethod.POST)
	public String rentalInfoSelect(){
		return "";
	}
	
}
