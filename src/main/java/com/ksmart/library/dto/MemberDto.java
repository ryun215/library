package com.ksmart.library.dto;

public class MemberDto {
	private String memberId;
	private int memberlevelCode;
	private String memberName;
	private String memberPhone;
	public MemberDto() {
		super();
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMemberlevelCode() {
		return memberlevelCode;
	}
	public void setMemberlevelCode(int memberlevelCode) {
		this.memberlevelCode = memberlevelCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberlevelCode=" + memberlevelCode + ", memberName=" + memberName
				+ ", memberPhone=" + memberPhone + "]";
	}
	
	
}
