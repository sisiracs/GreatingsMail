package com.l7.maven.pegasus_m;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MailSMTP {
	 Session mailSession;
	 
//	    public static void main(String args[]) throws AddressException, MessagingException
//	    {
//	    	MailSMTP javaEmail = new MailSMTP();
//	    	javaEmail.setMailServerProperties();
//	    	javaEmail.draftEmailMessage();
//	    	javaEmail.sendEmail();
//	    }
	    
	    public void mailSent(String[] toEmails,String emailBody, String emailSubject) throws AddressException, MessagingException {
	    	MailSMTP javaEmail = new MailSMTP();
	    	javaEmail.setMailServerProperties();
	    	//javaEmail.draftEmailMessage();
	    	javaEmail.sendEmail(toEmails, emailBody, emailSubject);
	    }
	 
	    private void setMailServerProperties()
	    {
	        Properties emailProperties = System.getProperties();
	        emailProperties.put("mail.smtp.port", "587");//587
	        emailProperties.put("mail.smtp.auth", "true");
	        emailProperties.put("mail.smtp.starttls.enable", "true");
	        mailSession = Session.getDefaultInstance(emailProperties, null);
	    }
	 
	    private MimeMessage draftEmailMessage(String[] toEmails,String emailBody, String emailSubject ) throws AddressException, MessagingException
	    {
	       // String[] toEmails = { "joseph@litmus7.com" };
	       // String emailSubject = "Test email subject";
	      //  String emailBody = "<body><h1>HElOOo!!</h1> </body>";
	        MimeMessage emailMessage = new MimeMessage(mailSession);
	        /**
	         * Set the mail recipients
	         * */
	        for (int i = 0; i < toEmails.length; i++)
	        {
	            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
	        }
	      //  Message.RecipientType.CC
	        emailMessage.setSubject(emailSubject);
	        /**
	         * If sending HTML mail
	         * */
	        emailMessage.setContent(emailBody, "text/html");
	        /**
	         * If sending only text mail
	         * */
	        //emailMessage.setText(emailBody);// for a text email
	        return emailMessage;
	    }
	 
	    private void sendEmail(String[] toEmails,String emailBody, String emailSubject) throws AddressException, MessagingException
	    {
	        /**
	         * Sender's credentials
	         * */
	    	
	    	 String fromUser = "";
		        String fromUserEmailPassword = "";
	    	
	 
	        String emailHost = "smtp.gmail.com";
	        Transport transport = mailSession.getTransport("smtp");
	        transport.connect(emailHost, fromUser, fromUserEmailPassword);
	        /**
	         * Draft the message
	         * */
	        
	        MimeMessage emailMessage = draftEmailMessage(toEmails, emailBody, emailSubject);
	        /**
	         * Send the mail
	         * */
	        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
	        transport.close();
	        System.out.println("Email sent successfully.");
	    }

}
