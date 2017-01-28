package com.ksmart.library.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksmart.library.dto.MemberDto;
import com.ksmart.library.dto.MemberLevelDto;

@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;
	
	String memberNameSpace = "com.ksmart.library.member.service.MemberMapper.";
	
	//������Ѹ���Ʈ ��ȸ
	public List<MemberLevelDto> memberLevelSelect(){
		logger.debug("Dao ����");
		return sqlSessionTemplate.selectList(memberNameSpace+"selectMemberLevel");
	}
	
	//�������
	public int memberInsert(MemberDto member){
		return sqlSessionTemplate.insert(memberNameSpace+"memberInsert", member);
		
	}
}
