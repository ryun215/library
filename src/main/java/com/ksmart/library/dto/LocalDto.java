package com.ksmart.library.dto;

public class LocalDto {
	private int localCode;
	private String localName;
	
	public LocalDto() {
		super();
	}

	

	public int getLocalCode() {
		return localCode;
	}



	public void setLocalCode(int localCode) {
		this.localCode = localCode;
	}



	public String getLocalName() {
		return localName;
	}



	public void setLocalName(String localName) {
		this.localName = localName;
	}



	@Override
	public String toString() {
		return "LocalDto [localCode=" + localCode + ", localName=" + localName + "]";
	}




	
}
