package com.ksmart.library.dto;

public class BookDto {
	private String bookCode;
	private String libraryId;
	private int stateCode;
	private int genreCode;
	private int bookRentalstateCode;
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private String bookFirstday;
	private int bookTotalday;
	private int bookTotalcount;
	
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	public int getGenreCode() {
		return genreCode;
	}
	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
	}
	
	public int getBookRentalstateCode() {
		return bookRentalstateCode;
	}
	public void setBookRentalstateCode(int bookRentalstateCode) {
		this.bookRentalstateCode = bookRentalstateCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookFirstday() {
		return bookFirstday;
	}
	public void setBookFirstday(String bookFirstday) {
		this.bookFirstday = bookFirstday;
	}
	public int getBookTotalday() {
		return bookTotalday;
	}
	public void setBookTotalday(int bookTotalday) {
		this.bookTotalday = bookTotalday;
	}
	public int getBookTotalcount() {
		return bookTotalcount;
	}
	public void setBookTotalcount(int bookTotalcount) {
		this.bookTotalcount = bookTotalcount;
	}
	@Override
	public String toString() {
		return "BookDto [bookCode=" + bookCode + ", libraryId=" + libraryId + ", stateCode=" + stateCode
				+ ", genreCode=" + genreCode + ", bookRentalstateCode=" + bookRentalstateCode + ", bookName=" + bookName
				+ ", bookAuthor=" + bookAuthor + ", bookPublisher=" + bookPublisher + ", bookFirstday=" + bookFirstday
				+ ", bookTotalday=" + bookTotalday + ", bookTotalcount=" + bookTotalcount + "]";
	}

	
}
