package com.ksmart.library.member.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ksmart.library.HomeController;
import com.ksmart.library.dto.MemberDto;
import com.ksmart.library.dto.MemberLevelDto;
import com.ksmart.library.member.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
	//멤버레벨조회
	@RequestMapping(value="/member/memberInsert", method=RequestMethod.GET)
	public String memberInsert(Model model){
		System.out.println("컨트롤러로 들어옴");
		List<MemberLevelDto> memberlevel = memberService.memberLevelSelect();
		model.addAttribute("memberlevel", memberlevel);
		return "/library/member/memberInsertForm";
	}
	//멤버 가입
	@RequestMapping(value="/member/memberInsert" , method=RequestMethod.POST)
	public String memberInsert(MemberDto member){
		logger.debug("member 값확인 "+member.toString());
		memberService.memberInsert(member);
		return "redirect:/member/memberInsert";
		
	}
}
