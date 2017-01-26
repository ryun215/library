package com.ksmart.library.service;

import java.util.List;

import com.ksmart.library.dto.LibraryDto;
import com.ksmart.library.dto.LocalDto;

public interface LibraryService {

	List<LocalDto> localNameSelect();
	int libraryInsert(LibraryDto library);
	LibraryDto login(LibraryDto library);
}
