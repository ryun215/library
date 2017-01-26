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
		logger.debug("LibraryDaoImpl�� LocalNameSelect ȣ��");
		return sqlSessionTemplate.selectList(LibraryNameSpace+"localName");
	}

	@Override
	public int libraryInsert(LibraryDto library) {
		logger.debug("LibraryDaoImpl�� libraryInsertȣ��");
		logger.debug("Dao���� library �� �Ѱܹ޾Ҵ��� Ȯ��"+library.toString());
		return sqlSessionTemplate.insert(LibraryNameSpace+"libraryInsert", library);
	}

}
