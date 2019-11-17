package com.l7.pegasus.dto;

import java.util.Date;

public class BirthdayHuman {

	private Date DOB;

	private String name;

	private String imgSrc;
	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BirthdayHuman(Date dOB, String name, String imgSrc,String email) {

		this.name = name;
		DOB = dOB;
		this.imgSrc = imgSrc;
		this.email=email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
}
