package com.ksmart.library.dto;

public class GenreDto {
	private int genreCode;
	private String genreName;
	
	public GenreDto() {
		super();
	}

	public int getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "genreDto [genreCode=" + genreCode + ", genreName=" + genreName + "]";
	}
	
	
}
