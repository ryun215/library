package com.ksmart.library.book.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ksmart.library.book.service.BookService;
import com.ksmart.library.controller.LibraryController;
import com.ksmart.library.dto.BookDto;
import com.ksmart.library.dto.GenreDto;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookService bookService;
	
	//도서등록 화면으로 감
	@RequestMapping(value="/book/bookInsert", method=RequestMethod.GET)
	public String bookInsert(Model model){
		List<GenreDto> genre = bookService.selectGenre();
		logger.debug("book컨트롤러 genre확인 :"+genre);
		model.addAttribute("genre", genre);
		return "/library/book/bookInsertForm";
		
	}
	//도서등록화면에서 도서정보 입력받아 도서등록요청
	@RequestMapping(value="/book/bookInsert", method=RequestMethod.POST)
	public String bookInsert(BookDto book){
		logger.debug(book.toString());
		bookService.bookInsert(book);
		
		return "/library/book/bookInsertForm";
	}
}
