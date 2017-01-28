package com.ksmart.library.book.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksmart.library.book.controller.BookController;
import com.ksmart.library.dto.BookDto;
import com.ksmart.library.dto.DisposalDto;
import com.ksmart.library.dto.GenreDto;

@Service
public class BookService {
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	@Autowired
	private BookDao bookDao;
	
	//�����帣 �������� select
	public List<GenreDto> selectGenre(){
		return bookDao.selectGenre();
	}
	//���� ���
	public int bookInsert(BookDto book){
		return bookDao.bookInsert(book);
	}
	//���� ��⸦ ���� �����ڵ�� �������� select�Ͽ� disposal�� �� �Ű� insert
	public int bookSelectAndDisposal(DisposalDto bookCode){
		System.out.println("��⵵���ڵ� Ȯ�� Service :"+bookCode.getBookCode());
		BookDto bookInfo = bookDao.bookSelect(bookCode);
		logger.debug("bookInfo :"+bookInfo);
		return bookDao.disposalInsert(bookInfo);
	}
		


		

	
}
