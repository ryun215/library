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
	
	//������� ȭ������ ��
	@RequestMapping(value="/book/bookInsert", method=RequestMethod.GET)
	public String bookInsert(Model model){
		List<GenreDto> genre = bookService.selectGenre();
		logger.debug("book��Ʈ�ѷ� genreȮ�� :"+genre);
		model.addAttribute("genre", genre);
		return "/library/book/bookInsertForm";
		
	}
	//�������ȭ�鿡�� �������� �Է¹޾� ������Ͽ�û
	@RequestMapping(value="/book/bookInsert", method=RequestMethod.POST)
	public String bookInsert(BookDto book){
		logger.debug(book.toString());
		bookService.bookInsert(book);
		
		return "/library/book/bookInsertForm";
	}
}
