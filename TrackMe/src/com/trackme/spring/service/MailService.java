package com.trackme.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Service
public class MailService {
	
	@Autowired(required=false)
    JavaMailSender mailSender;
	
	
	public boolean sendMail(String fromEmail, List<String> toList, List<String> ccList, String message,String subject){
		InternetAddress[] toAddress= null;//new InternetAddress[9];
		if(toList!=null){

			 toAddress= new InternetAddress[toList.size()]; 
			 int i =0;
			for(String toMail: toList)
				try {
					toAddress[i]= new InternetAddress(toMail);
					i++;
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} 
		InternetAddress[] ccAddress = null;// new ArrayList<>();  
		if(ccList!=null){
			ccAddress = new InternetAddress[ccList.size()]; 
			int i=0;
			for(String ccMail: ccList)
				try {
					ccAddress[i]=new InternetAddress(ccMail);
					i++;
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} 
		
		MimeMessagePreparator preparator = getMessagePreparator(fromEmail,toAddress,ccAddress,message,subject);
		 
        try {
            mailSender.send(preparator);
           System.out.println("Message Send...Hurrey");
            return false;
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
		
		
	}
	
	
	
	 private MimeMessagePreparator getMessagePreparator(String fromEmail, InternetAddress[] toList, InternetAddress[] ccList, String message, String subject) {
		 
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
	 
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	                mimeMessage.setFrom( new InternetAddress(fromEmail));;
	                mimeMessage.addRecipients(Message.RecipientType.TO,
	                		toList);
	                
	                mimeMessage.addRecipients(Message.RecipientType.CC,
	                		ccList);
	                Multipart multipart = new MimeMultipart( "alternative" );

	                MimeBodyPart htmlPart = new MimeBodyPart();
	                htmlPart.setContent( message, "text/html; charset=utf-8" );
	                multipart.addBodyPart( htmlPart );
	                mimeMessage.setContent( multipart );
 
	                mimeMessage.setSubject(subject);
	            }
	        };
	        return preparator;
	    }
	 
	
}
