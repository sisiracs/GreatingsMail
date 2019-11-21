package com.l7.dto;

public class MailData {
	
	private String[] ccEmail;
	private String[] bccEmail;

	private String fromUser;
	private String fromUserEmailPassword;

	public MailData(String[] ccEmail, String[] bccEmail, String fromUser, String fromUserEmailPassword) {
		// super();

		this.ccEmail = ccEmail;
		this.bccEmail = bccEmail;
		this.fromUser = fromUser;
		this.fromUserEmailPassword = fromUserEmailPassword;
	}

	public MailData() {
		// TODO Auto-generated constructor stub
	}

	public String[] getCcEmail() {
		return ccEmail;
	}

	public void setCcEmail(String[] ccEmail) {
		this.ccEmail = ccEmail;
	}

	public String[] getBccEmail() {
		return bccEmail;
	}

	public void setBccEmail(String[] bccEmail) {
		this.bccEmail = bccEmail;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getFromUserEmailPassword() {
		return fromUserEmailPassword;
	}

	public void setFromUserEmailPassword(String fromUserEmailPassword) {
		this.fromUserEmailPassword = fromUserEmailPassword;
	}

}
