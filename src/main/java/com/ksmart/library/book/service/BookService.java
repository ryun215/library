package com.ksmart.library.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksmart.library.dto.BookDto;
import com.ksmart.library.dto.GenreDto;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	//도서장르 가져오는 select
	public List<GenreDto> selectGenre(){
		return bookDao.selectGenre();
	}
	
	public int bookInsert(BookDto book){
		return bookDao.bookInsert(book);
	}
}
