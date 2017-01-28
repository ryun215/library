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
	//������� ����Ʈ ��ȸ
	public List<MemberLevelDto> memberLevelSelect(){
		logger.debug("service ����");
		
		return memberDao.memberLevelSelect();
	}
	//�������
	public int memberInsert(MemberDto member){
		return memberDao.memberInsert(member);
	}
}
