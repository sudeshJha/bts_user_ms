package com.bts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bts.utils.EmailTemplate;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendVerificationMail(String name, String to, String verificationLink){
		String subject = "This is a verification mail from Nimbus.";
		
		String body = EmailTemplate.getVerificationEmailTemplate(name, verificationLink);
	
		try {
			
			sendMail(to, subject, body, true);
		}catch(MessagingException exp) {
			System.out.println("Error Sending Mail");
			System.out.println(exp.getMessage());
		}
		
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
