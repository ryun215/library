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
	
	//도서장르 가져오는 select
	public List<GenreDto> selectGenre(){
		return bookDao.selectGenre();
	}
	//도서 등록
	public int bookInsert(BookDto book){
		return bookDao.bookInsert(book);
	}
	//도서 폐기를 위해 도서코드로 도서정보 select하여 disposal에 값 옮겨 insert
	public int bookSelectAndDisposal(DisposalDto bookCode){
		System.out.println("폐기도서코드 확인 Service :"+bookCode.getBookCode());
		BookDto bookInfo = bookDao.bookSelect(bookCode);
		logger.debug("bookInfo :"+bookInfo);
		return bookDao.disposalInsert(bookInfo);
	}
		


		

	
}
