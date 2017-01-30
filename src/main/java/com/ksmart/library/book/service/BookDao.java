package com.ksmart.library.book.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksmart.library.dto.BookDto;
import com.ksmart.library.dto.DisposalDto;
import com.ksmart.library.dto.GenreDto;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String BookNameSpace = "com.ksmart.library.book.service.Mapper.";
	//도서 장르가져오는 select
	public List<GenreDto> selectGenre(){
		return sqlSessionTemplate.selectList(BookNameSpace+"selectGenre");
	}
	
	//도서 등록
	public int bookInsert(BookDto book){
		return sqlSessionTemplate.insert(BookNameSpace+"bookInsert", book);
	}
	//도서한권의 정보 조회
	public BookDto bookSelect(DisposalDto bookCode){
		System.out.println("폐기도서코드 확인 Dao :"+bookCode.getBookCode());
		return sqlSessionTemplate.selectOne(BookNameSpace+"bookSelect", bookCode);
	}
	//폐기도서정보 등록
	public int disposalInsert(BookDto book){
		return sqlSessionTemplate.insert(BookNameSpace+"disposalInsert", book);
	}
	//도서폐기시 도서테이블의 상태 변경
	public int stateUpdate(DisposalDto book){
		return sqlSessionTemplate.update(BookNameSpace+"stateUpdate", book);
	}
}
