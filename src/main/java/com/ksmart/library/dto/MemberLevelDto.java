package com.ksmart.library.dto;

public class MemberLevelDto {
	private int memberlevelCode;
	private String memberlevelName;
	private int payment;
	
	public MemberLevelDto() {
		super();
	}

	public int getMemberlevelCode() {
		return memberlevelCode;
	}

	public void setMemberlevelCode(int memberlevelCode) {
		this.memberlevelCode = memberlevelCode;
	}

	public String getMemberlevelName() {
		return memberlevelName;
	}

	public void setMemberlevelName(String memberlevelName) {
		this.memberlevelName = memberlevelName;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "MemberLevelDto [memberlevelCode=" + memberlevelCode + ", memberlevelName=" + memberlevelName
				+ ", payment=" + payment + "]";
	}
	
	
	
}
