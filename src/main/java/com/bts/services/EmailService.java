package com.bts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bts.utils.EmailTemplate;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendVerificationMail(String name, String to, String verificationLink) throws MessagingException{
		String subject = "This is a verification mail from Nimbus.";
		
		String body = EmailTemplate.getVerificationEmailTemplate(name, verificationLink);
	
		sendMail(to, subject, body, true);
		
	}
	
	public void sendMail(String to, String subject, String body, boolean isHtml) throws MessagingException{
		
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setFrom("sudeshjha2005@gmail.com");
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, isHtml);
		
		mailSender.send(message);
	}	
}
