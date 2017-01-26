package com.ksmart.library.dto;

public class LibraryDto {
	private String libraryId;
	private int localCode;
	private String libraryPw;
	public LibraryDto() {
		super();
	}
	public String getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}
	public int getLocalCode() {
		return localCode;
	}
	public void setLocalCode(int localCode) {
		this.localCode = localCode;
	}
	public String getLibraryPw() {
		return libraryPw;
	}
	public void setLibraryPw(String libraryPw) {
		this.libraryPw = libraryPw;
	}
	@Override
	public String toString() {
		return "LibraryDto [libraryId=" + libraryId + ", localCode=" + localCode + ", libraryPw=" + libraryPw + "]";
	}
	
	
}
