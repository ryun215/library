package com.ksmart.library.rental.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksmart.library.dto.BookDto;
import com.ksmart.library.dto.RentalDto;
import com.ksmart.library.dto.ReturnDto;

@Repository
public class RentalDao {
	private static final Logger logger = LoggerFactory.getLogger(RentalDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	String rentalNameSpace = "com.ksmart.library.rental.service.RentalMapper.";
	
	//���� �����ڵ� ������
	public int bookStateSelect(RentalDto rental){
		logger.debug("�������¼���ƮDao");
		int x = sqlSessionTemplate.selectOne(rentalNameSpace+"stateSelect", rental);
		System.out.println("�����ڵ� Ȯ�� :"+ x);
		return x;
	}
	//���� �����ڵ� ������Ʈ
	public int bookStateUpdate(RentalDto rental){
		logger.debug("�������¾�����ƮDao");
		
		return sqlSessionTemplate.update(rentalNameSpace+"stateUpdate", rental);
	}
	//�����뿩 �Է�
	public int rentalInsert(RentalDto rental){
		return  sqlSessionTemplate.insert(rentalNameSpace+"rentalInsert", rental);
	}
	//���̵�Ȯ��
	public String idCheck(RentalDto rental){
		return sqlSessionTemplate.selectOne(rentalNameSpace+"idCheck", rental);
	}
	//�����ڵ带 ������ ��Ż���� ��ȸ
	public ReturnDto rentalInfoSelect(String bookCode){
		return sqlSessionTemplate.selectOne(rentalNameSpace+"rentalInfoSelect", bookCode);
	}
	//��Ż���� ������Ʈ
	public int rentalUpdate(ReturnDto bookReturn){
		return sqlSessionTemplate.update(rentalNameSpace+"rentalUpdate", bookReturn);
	}
	
	//���� total��,firstday ��ȸ
	public BookDto bookTotalSelect(ReturnDto rt){
		return sqlSessionTemplate.selectOne(rentalNameSpace+"bookTotalSelect", rt);
	}
	
	//���� firstday ������Ʈ
	public int bookFirstDayUpdate(ReturnDto rt){
		return sqlSessionTemplate.update(rentalNameSpace+"firstDayUpdate", rt);
	}
	
	//���� total ������Ʈ
	public int bookTotalUpdate(BookDto book){
		return sqlSessionTemplate.update(rentalNameSpace+"bookTotalUpdate", book);
	}
}
