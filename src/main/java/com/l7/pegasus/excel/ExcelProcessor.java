package com.l7.pegasus.excel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.l7.maven.pegasus_m.MailSMTP;
import com.l7.pegasus.dto.BirthdayHuman;
import com.l7.pegasus.templete.Templetes;
import com.l7.pegasus.util.DateConversion;

public class ExcelProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelReader rederobj = new ExcelReader();
		ExcelWritter writerObj = new ExcelWritter();

		DateConversion dataConvObj = new DateConversion();
		LocalDate currentDate = LocalDate.now();
		LocalDate DobDate;

		Templetes templetObj = new Templetes();

		String excelFilePath = "data/Book.xlsx";
		String congif = "data/templetselect.xlsx";
		ExcelReader reader = new ExcelReader();
		List<BirthdayHuman> listBirth = null;

		try {
			listBirth = reader.readFromExcelFile(excelFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!listBirth.isEmpty()) {

			for (BirthdayHuman birth : listBirth) {
				// System.out.println(birth.getDOB().);
				DobDate = dataConvObj.convertToLocalDateViaInstant(birth.getDOB());
				if (DobDate.getDayOfMonth() == currentDate.getDayOfMonth()
						&& DobDate.getMonthValue() == currentDate.getMonthValue()) {
					System.out.println(DobDate);
					MailSMTP smtpobj = new MailSMTP();
					String[] toEmails = { birth.getEmail() };
					double current = 1;
					try {
						current = rederobj.readtempletValueExcelFile(congif);
						System.out.println(current);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					String emailBody = "";
					String emailSubject = "Happy Birthday ";
					try {

						emailBody = templetObj.templete(current);
						// emailBody=emailBody.replaceAll("__---__",
						// "https://images.unsplash.com/photo-1530103862676-de8c9debad1d?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");

						emailBody = emailBody.replaceAll("__####---####__", birth.getImgSrc());
						emailBody = emailBody.replaceAll("__###---###__", birth.getName());// __###---###___
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					current = templeteupdate(current);
					try {
						writerObj.createExcel(congif, current);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					emailSubject = emailSubject + birth.getName();
					try {
						smtpobj.mailSent(toEmails, emailBody, emailSubject);
					} catch (AddressException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			System.out.println("empty");
		}
	}

	public static double templeteupdate(double current) {
		double limit = 3;
		if (current == limit) {
			current = 1;
		} else {
			current++;
		}

		return current;
	}

}
