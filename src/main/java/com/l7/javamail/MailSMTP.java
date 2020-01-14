package com.l7.javamail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.l7.dto.MailData;

public class MailSMTP {
	Session mailSession;
kasgdkgsakdgaskdga
	public void mailSent(MailData mailobj, String[] toEmail, String emailSubject, String emailBody)
			throws AddressException, MessagingException {
		MailSMTP javaEmail = new MailSMTP();
		javaEmail.setMailServerProperties();
		javaEmail.sendEmail(mailobj, toEmail, emailSubject, emailBody);
	}

	private void setMailServerProperties() {
		Properties emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", "587");
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		mailSession = Session.getDefaultInstance(emailProperties, null);
	}

	private MimeMessage draftEmailMessage(MailData mailobj, String[] toEmail, String emailSubject, String emailBody)
			throws AddressException, MessagingException {

		MimeMessage emailMessage = new MimeMessage(mailSession);
		/**
		 * Set the mail recipients
		 */
		for (int i = 0; i < toEmail.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail[i]));
		}

		for (int i = 0; i < mailobj.getCcEmail().length; i++) {
			emailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(mailobj.getCcEmail()[i]));
		}

		for (int i = 0; i < mailobj.getBccEmail().length; i++) {
			emailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(mailobj.getBccEmail()[i]));
		}
		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");
		return emailMessage;
	}

	private void sendEmail(MailData mailobj, String[] toEmail, String emailSubject, String emailBody)
			throws AddressException, MessagingException {

		String emailHost = "smtp.gmail.com";
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(emailHost, mailobj.getFromUser(), mailobj.getFromUserEmailPassword());
		MimeMessage emailMessage = draftEmailMessage(mailobj, toEmail, emailSubject, emailBody);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}

}
