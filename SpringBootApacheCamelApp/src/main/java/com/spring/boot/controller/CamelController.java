package com.spring.boot.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelController {

	@Autowired
	ProducerTemplate producerTemplate;

	@GetMapping("/test")
	public String testService(@RequestParam Integer id) {

		producerTemplate.sendBody("direct:test", id);

		return "Test";
	}

	@GetMapping("/test/static")
	public String testStaticServie(@RequestParam Integer id) {
		producerTemplate.sendBody("direct:teststatic", id);

		return "Test";
	}

	@GetMapping("/test/dynamic")
	public String testDynamicServie(@RequestParam Integer id) {
		producerTemplate.sendBody("direct:testdynamic", id);

		return "Test";
	}

}
