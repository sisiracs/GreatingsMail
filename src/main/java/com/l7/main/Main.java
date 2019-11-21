package com.l7.main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import com.l7.dto.BirthdayHuman;
import com.l7.dto.MailData;
import com.l7.dto.TempletDto;
import com.l7.javamail.MailSMTP;
import com.l7.objectreadwritter.ExcelReader;
import com.l7.objectreadwritter.HtmlTempleteRead;
import com.l7.objectreadwritter.PropertiesFilesRead;
import com.l7.objectreadwritter.PropertiesFilesWrite;
import com.l7.util.DateConversion;

public class Main {
	static String excelFilePath = "data/Book.xlsx";
	static String mailPropertiesFilePath = "resources/mail.properties";
	static String templetePropertiesFilePath = "resources/templetsconfig.properties";
	static String htmlTempleteFilePath = "data/htmlTemplete/templete_";

	private static ExcelReader rederobj;
	private static DateConversion dataConvObj;
	private static LocalDate currentDate;
	private static LocalDate DobDate;
	private static PropertiesFilesRead propFilesRedObj;
	private static PropertiesFilesWrite propFilesWrtObj;
	private static MailSMTP smtpobj;
	private static MailData mailDataObj;
	private static TempletDto templeteDtoObj;
	private static List<BirthdayHuman> listBirth;
	private static HtmlTempleteRead htmlTempReadObj;

	public static void main(String[] args) {
		initialiseGlobalObjects();
		if (!listBirth.isEmpty()) {
			for (BirthdayHuman birth : listBirth) {
				if (isBirthday(birth)) {
					System.out.println(birth.getName()+"   "+DobDate);
					String[] toEmails = { birth.getEmail() };
					String emailSubject = "Happy Birthday " + birth.getName() + " !";
					String emailBody = reademailbody();
					emailBody = emailBody.replaceAll("__####---####__", birth.getImgSrc());
					emailBody = emailBody.replaceAll("__###---###__", birth.getName()+"!!");
					templeteDtoObj.updateCurrentTempleteNumber();
					sentMail(toEmails, emailSubject, emailBody);
				}
			}
		} else {
			System.out.println("Birth day List empty");
		}
		closingFunctions();
	}

	public static void closingFunctions() {
		try {
			propFilesWrtObj.templeteConfigWrite(templetePropertiesFilePath, templeteDtoObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialiseGlobalObjects() {
		rederobj = new ExcelReader();
		dataConvObj = new DateConversion();
		currentDate = LocalDate.now();
		propFilesRedObj = new PropertiesFilesRead();
		propFilesWrtObj = new PropertiesFilesWrite();
		smtpobj = new MailSMTP();
		htmlTempReadObj = new HtmlTempleteRead();
		try {
			mailDataObj = propFilesRedObj.mailConfigRead(mailPropertiesFilePath);
			templeteDtoObj = propFilesRedObj.templeteConfigRead(templetePropertiesFilePath);
			listBirth = rederobj.readFromExcelFile(excelFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static boolean isBirthday(BirthdayHuman birth) {
		DobDate = dataConvObj.convertToLocalDateViaInstant(birth.getDOB());
		return (DobDate.getDayOfMonth() == currentDate.getDayOfMonth()
				&& DobDate.getMonthValue() == currentDate.getMonthValue());

	}

	public static boolean sentMail(String[] toEmail, String emailSubject, String emailBody) {

		try {
			smtpobj.mailSent(mailDataObj, toEmail, emailSubject, emailBody);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static String reademailbody() {
		String emailBody = "";
		String filepath=htmlTempleteFilePath + templeteDtoObj.getCurrentTempleteNumber() + ".html";
		try {
			emailBody = htmlTempReadObj
					.readHTMLtemplete(filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emailBody;
	}

}
