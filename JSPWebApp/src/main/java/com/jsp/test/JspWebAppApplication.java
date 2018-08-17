package com.jsp.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class JspWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspWebAppApplication.class, args);
	}
}

@RestController
class TestController{
	
	@GetMapping("/test")
	public ModelAndView test() {
		return new ModelAndView("time");
	}
	
}
