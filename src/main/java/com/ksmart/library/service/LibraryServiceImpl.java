package com.ksmart.library.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksmart.library.dto.LocalDto;

@Service
public class LibraryServiceImpl implements LibraryService{
	private static final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);
	@Autowired
	private LibraryDao libraryDao;
	
	@Override
	public List<LocalDto> localNameSelect( ) {
		logger.debug("LibraryServiceImpl¿« localNameSelect»£√‚");
		return libraryDao.localNameSelect();
	}

}
