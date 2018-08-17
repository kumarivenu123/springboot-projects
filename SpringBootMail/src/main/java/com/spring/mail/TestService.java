package com.spring.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	private MailSender mailSender;

	public String sendMail() throws Exception {
		String message;
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("mca143341@gmail.com");
		simpleMailMessage.setFrom("bootchatapp@gmal.com");
		simpleMailMessage.setSubject("App Vefication");
		simpleMailMessage.setText("Your Verifaction code :"+213 );
		try {
			mailSender.send(simpleMailMessage);
			message = "Mail sended successfully.";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			message = "Faild to Send mail";
		}

		return message;
	}

}
