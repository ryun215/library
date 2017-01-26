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
		logger.debug("LibraryServiceImpl�� localNameSelectȣ��");
		return libraryDao.localNameSelect();
	}

	@Override
	public int libraryInsert(LibraryDto library) {
		logger.debug("LibraryServiceImpl�� libraryInsert ȣ��");
		logger.debug("���񽺿��� library �� �Ѱܹ޾Ҵ��� Ȯ��"+library.toString());
		
		return libraryDao.libraryInsert(library);
	}

	@Override
	public LibraryDto login(LibraryDto library) {
		LibraryDto libraryMember = libraryDao.login(library);
		logger.debug("�α����Ҷ� �Է¹��� ���� �ִ��� Ȯ������ :"+libraryMember.toString());
		//��ȿ���˻� �ұ�??
		return libraryMember;
	}

}
