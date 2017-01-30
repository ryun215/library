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
	//���� �帣�������� select
	public List<GenreDto> selectGenre(){
		return sqlSessionTemplate.selectList(BookNameSpace+"selectGenre");
	}
	
	//���� ���
	public int bookInsert(BookDto book){
		return sqlSessionTemplate.insert(BookNameSpace+"bookInsert", book);
	}
	//�����ѱ��� ���� ��ȸ
	public BookDto bookSelect(DisposalDto bookCode){
		System.out.println("��⵵���ڵ� Ȯ�� Dao :"+bookCode.getBookCode());
		return sqlSessionTemplate.selectOne(BookNameSpace+"bookSelect", bookCode);
	}
	//��⵵������ ���
	public int disposalInsert(BookDto book){
		return sqlSessionTemplate.insert(BookNameSpace+"disposalInsert", book);
	}
	//�������� �������̺��� ���� ����
	public int stateUpdate(DisposalDto book){
		return sqlSessionTemplate.update(BookNameSpace+"stateUpdate", book);
	}
}
