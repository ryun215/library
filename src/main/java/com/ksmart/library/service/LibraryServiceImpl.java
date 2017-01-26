package com.ksmart.library.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksmart.library.dto.LibraryDto;
import com.ksmart.library.dto.LocalDto;

@Service
public class LibraryServiceImpl implements LibraryService{
	private static final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);
	@Autowired
	private LibraryDao libraryDao;
	
	@Override
	public List<LocalDto> localNameSelect( ) {
		logger.debug("LibraryServiceImpl의 localNameSelect호출");
		return libraryDao.localNameSelect();
	}

	@Override
	public int libraryInsert(LibraryDto library) {
		logger.debug("LibraryServiceImpl의 libraryInsert 호출");
		logger.debug("서비스에서 library 잘 넘겨받았는지 확인"+library.toString());
		
		return libraryDao.libraryInsert(library);
	}

	@Override
	public LibraryDto login(LibraryDto library) {
		LibraryDto libraryMember = libraryDao.login(library);
		logger.debug("로그인할때 입력받은 값이 있는지 확인해줌 :"+libraryMember.toString());
		//유효성검사 할까??
		return libraryMember;
	}

}
