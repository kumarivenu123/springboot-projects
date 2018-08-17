package com.spring.sleuth;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/service")
public class TestController {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping("/get")
	public String testService() {
		String test = null;
		LOGGER.info("Calling Service");
		return test.trim();
	}

}
