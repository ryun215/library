package com.ksmart.library.book.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksmart.library.dto.BookDto;
import com.ksmart.library.dto.GenreDto;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String BookNameSpace = "com.ksmart.library.book.service.Mapper.";
	//���� �帣�������� select
	public List<GenreDto> selectGenre(){
		return sqlSessionTemplate.selectList(BookNameSpace+"selectGenre");
	}
	
	//���� ���
	public int bookInsert(BookDto book){
		return sqlSessionTemplate.insert(BookNameSpace+"bookInsert", book);
	}
}