package com.l7.objectreadwritter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.l7.dto.MailData;
import com.l7.dto.TempletDto;

public class PropertiesFilesRead {

	public static void main(String[] args) {
		PropertiesFilesRead obj = new PropertiesFilesRead();
		try {
			MailData mailObj = obj.mailConfigRead("resources/mail.properties");
			System.out.println(mailObj.getCcEmail()[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public MailData mailConfigRead(String filepath) throws IOException {
		InputStream input = new FileInputStream(new File(filepath));
		Properties prop = new Properties();
		prop.load(input);
		MailData mailObj = new MailData();

		String[] ccmail = prop.getProperty("ccEmail").split(">>");
		String[] bccmail = prop.getProperty("bccEmail").split(">>");
		mailObj.setCcEmail(ccmail);
		mailObj.setBccEmail(bccmail);
		mailObj.setFromUser(prop.getProperty("fromUser"));
		mailObj.setFromUserEmailPassword(prop.getProperty("fromUserEmailPassword"));
		return mailObj;

	}
	
	public TempletDto templeteConfigRead(String filepath) throws IOException {
		InputStream input = new FileInputStream(new File(filepath));
		Properties prop = new Properties();
		prop.load(input);
		TempletDto templetObj = new TempletDto();
		templetObj.setCurrentTempleteNumber(Integer.parseInt(prop.getProperty("currentTempleteNumber")));
		templetObj.setTotalNUmberOfTemeplete(Integer.parseInt(prop.getProperty("TotalNUmberOfTemeplete")));
		return templetObj;
		
	}
}
