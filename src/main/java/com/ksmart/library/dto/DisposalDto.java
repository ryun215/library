package com.ksmart.library.dto;

public class DisposalDto {
	private int disposalCode;
	private int genreCode;
	private int bookCode;
	private String disposalBookName;
	private String disposalAuthor;
	private String disposalPublisher;
	private String disposalRegisterDay;
	public DisposalDto() {
		super();
	}
	public int getDisposalCode() {
		return disposalCode;
	}
	public void setDisposalCode(int disposalCode) {
		this.disposalCode = disposalCode;
	}
	public int getGenreCode() {
		return genreCode;
	}
	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getDisposalBookName() {
		return disposalBookName;
	}
	public void setDisposalBookName(String disposalBookName) {
		this.disposalBookName = disposalBookName;
	}
	public String getDisposalAuthor() {
		return disposalAuthor;
	}
	public void setDisposalAuthor(String disposalAuthor) {
		this.disposalAuthor = disposalAuthor;
	}
	public String getDisposalPublisher() {
		return disposalPublisher;
	}
	public void setDisposalPublisher(String disposalPublisher) {
		this.disposalPublisher = disposalPublisher;
	}
	public String getDisposalRegisterDay() {
		return disposalRegisterDay;
	}
	public void setDisposalRegisterDay(String disposalRegisterDay) {
		this.disposalRegisterDay = disposalRegisterDay;
	}
	@Override
	public String toString() {
		return "DistposalDto [disposalCode=" + disposalCode + ", genreCode=" + genreCode + ", bookCode=" + bookCode
				+ ", disposalBookName=" + disposalBookName + ", disposalAuthor=" + disposalAuthor
				+ ", disposalPublisher=" + disposalPublisher + ", disposalRegisterDay=" + disposalRegisterDay + "]";
	}
	
	
}
