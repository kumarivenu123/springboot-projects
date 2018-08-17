package com.example.SpringBootApacheCamelApp1;

import javax.websocket.server.PathParam;

import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private ProducerTemplate producerTemplate;

	public TestController(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	
	@GetMapping("/testroute")
	public Employee test() {
		Employee employee = new Employee();
		producerTemplate.sendBody("direct:findempidroute", employee);
		return employee;
	}
	
	
	@GetMapping("/test/sendmail/{count}")
	public String mailService(@PathVariable("count") Integer count) {
		producerTemplate.asyncSendBody("direct:sendmail", count);
		return "success";
	}
	

}
