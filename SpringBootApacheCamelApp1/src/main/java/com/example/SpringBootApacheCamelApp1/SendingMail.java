package com.example.SpringBootApacheCamelApp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SendingMail {

	@Autowired
	private MailSender mailSender;

	public void sendMail(Integer count) throws Exception {

		for (int i = 1; i <= count; i++) {
			Employee employee = new Employee();
			employee.setEmpId(123);
			employee.setEmpName("venu");
			employee.setEmpAddress("nellore");
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo("kvenu9502@gmail.com");
			simpleMailMessage.setFrom("bootchatapp@gmal.com");
			simpleMailMessage.setSubject("BootChatApp Vefication");
			simpleMailMessage.setText("Camel Asyn Routing Test" + i);
			try {
				mailSender.send(simpleMailMessage);
			} catch (Exception e) {
				System.out.println("Exception while sending mail");
			}
		}

	}

}
