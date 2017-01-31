package com.ksmart.library.rental.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksmart.library.dto.RentalDto;
import com.ksmart.library.dto.ReturnDto;

@Repository
public class RentalDao {
	private static final Logger logger = LoggerFactory.getLogger(RentalDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	String rentalNameSpace = "com.ksmart.library.rental.service.RentalMapper.";
	
	//도서 상태코드 가져옴
	public int bookStateSelect(RentalDto rental){
		logger.debug("도서상태셀렉트Dao");
		int x = sqlSessionTemplate.selectOne(rentalNameSpace+"stateSelect", rental);
		System.out.println("상태코드 확인 :"+ x);
		return x;
	}
	//도서 상태코드 업데이트
	public int bookStateUpdate(RentalDto rental){
		logger.debug("도서상태업데이트Dao");
		
		return sqlSessionTemplate.update(rentalNameSpace+"stateUpdate", rental);
	}
	//도서대여 입력
	public int rentalInsert(RentalDto rental){
		return  sqlSessionTemplate.insert(rentalNameSpace+"rentalInsert", rental);
	}
	//아이디확인
	public String idCheck(RentalDto rental){
		return sqlSessionTemplate.selectOne(rentalNameSpace+"idCheck", rental);
	}
	//도서코드를 가지고 렌탈정보 조회
	public ReturnDto rentalInfoSelect(String bookCode){
		return sqlSessionTemplate.selectOne(rentalNameSpace+"rentalInfoSelect", bookCode);
	}
}
