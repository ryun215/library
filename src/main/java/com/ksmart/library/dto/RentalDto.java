package com.ksmart.library.dto;

public class RentalDto {
	private String rentalCode;
	private int bookCode;
	private String memberId;
	private int rentalStateCode;
	private String rentalStart;
	private String rentalEnd;
	private int rentalPayment;
	private int rentalPrePayment;
	public RentalDto() {
		super();
	}
	public String getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(String rentalCode) {
		this.rentalCode = rentalCode;
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRentalStart() {
		return rentalStart;
	}
	public void setRentalStart(String rentalStart) {
		this.rentalStart = rentalStart;
	}
	public String getRentalEnd() {
		return rentalEnd;
	}
	public void setRentalEnd(String rentalEnd) {
		this.rentalEnd = rentalEnd;
	}
	public int getRentalPayment() {
		return rentalPayment;
	}
	public void setRentalPayment(int rentalPayment) {
		this.rentalPayment = rentalPayment;
	}
	public int getRentalPrePayment() {
		return rentalPrePayment;
	}
	public void setRentalPrePayment(int rentalPrePayment) {
		this.rentalPrePayment = rentalPrePayment;
	}
	public int getRentalStateCode() {
		return rentalStateCode;
	}
	public void setRentalStateCode(int rentalStateCode) {
		this.rentalStateCode = rentalStateCode;
	}
	@Override
	public String toString() {
		return "RentalDto [rentalCode=" + rentalCode + ", bookCode=" + bookCode + ", memberId=" + memberId
				+ ", rentalStateCode=" + rentalStateCode + ", rentalStart=" + rentalStart + ", rentalEnd=" + rentalEnd
				+ ", rentalPayment=" + rentalPayment + ", rentalPrePayment=" + rentalPrePayment + "]";
	}
	

	
	
	
}
