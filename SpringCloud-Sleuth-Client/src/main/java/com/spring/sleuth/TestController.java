package com.spring.sleuth;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/test/client")
@RestController
public class TestController {
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/test")
	public String testServie() {
		LOGGER.info("Before Calling Client");
		String result = restTemplate.getForObject("http://localhost:6060/test/service/get", String.class);
		LOGGER.info("After Calling Client");
		return result;
	}

}
