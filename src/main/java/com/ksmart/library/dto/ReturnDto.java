package com.ksmart.library.dto;

public class ReturnDto {
	private int rentalCode;
	private String bookCode;
	private String bookName;
	private String memberName;
	private int memberlevelPayment;
	private int rentalPrePayment;
	private int totalPayment;
	private int willRiceivePay;
	private String rentalStart;
	private int rentDay;
	public int getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(int rentalCode) {
		this.rentalCode = rentalCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberlevelPayment() {
		return memberlevelPayment;
	}
	public void setMemberlevelPayment(int memberlevelPayment) {
		this.memberlevelPayment = memberlevelPayment;
	}
	public int getRentalPrePayment() {
		return rentalPrePayment;
	}
	public void setRentalPrePayment(int rentalPrePayment) {
		this.rentalPrePayment = rentalPrePayment;
	}
	public int getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	
	public String getRentalStart() {
		return rentalStart;
	}
	public void setRentalStart(String rentalStart) {
		this.rentalStart = rentalStart;
	}
	public int getWillRiceivePay() {
		return willRiceivePay;
	}
	public void setWillRiceivePay(int willRiceivePay) {
		this.willRiceivePay = willRiceivePay;
	}
	public int getRentDay() {
		return rentDay;
	}
	public void setRentDay(int rentDay) {
		this.rentDay = rentDay;
	}
	
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	@Override
	public String toString() {
		return "ReturnDto [rentalCode=" + rentalCode + ", bookCode=" + bookCode + ", bookName=" + bookName
				+ ", memberName=" + memberName + ", memberlevelPayment=" + memberlevelPayment + ", rentalPrePayment="
				+ rentalPrePayment + ", totalPayment=" + totalPayment + ", willRiceivePay=" + willRiceivePay
				+ ", rentalStart=" + rentalStart + ", rentDay=" + rentDay + "]";
	}
	
	
}
