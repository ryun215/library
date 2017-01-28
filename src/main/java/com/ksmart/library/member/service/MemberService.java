package com.ksmart.library.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksmart.library.dto.MemberDto;
import com.ksmart.library.dto.MemberLevelDto;

@Service
public class MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	@Autowired
	private MemberDao memberDao;
	//멤버권한 리스트 조회
	public List<MemberLevelDto> memberLevelSelect(){
		logger.debug("service 들어옴");
		
		return memberDao.memberLevelSelect();
	}
	//멤버가입
	public int memberInsert(MemberDto member){
		return memberDao.memberInsert(member);
	}
}
