package com.ksmart.library.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksmart.library.dto.LibraryDto;
import com.ksmart.library.dto.LocalDto;

@Repository
public class LibraryDaoImpl implements LibraryDao {
	private static final Logger logger = LoggerFactory.getLogger(LibraryDaoImpl.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String LibraryNameSpace = "com.kmart.librarl.service.Mapper.";
	
	@Override
	public List<LocalDto> localNameSelect() {
		logger.debug("LibraryDaoImpl의 LocalNameSelect 호출");
		return sqlSessionTemplate.selectList(LibraryNameSpace+"localName");
	}

	@Override
	public int libraryInsert(LibraryDto library) {
		logger.debug("LibraryDaoImpl의 libraryInsert호출");
		logger.debug("Dao에서 library 잘 넘겨받았는지 확인"+library.toString());
		return sqlSessionTemplate.insert(LibraryNameSpace+"libraryInsert", library);
	}

}
