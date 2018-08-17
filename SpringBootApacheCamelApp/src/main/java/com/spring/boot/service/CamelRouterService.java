package com.spring.boot.service;

import org.springframework.stereotype.Service;

@Service
public class CamelRouterService {

	public void testservice(String number) {
		System.out.println("Hi Your Number is :" + number);
	}

	public void testStaticService1(String number) {
		System.out.println("Hi Your Number is :" + number);
	}

	public void testStaticService2(String number) {
		System.out.println("Hi Your Number is :" + number);
	}

	public void testStaticService3(String number) {
		System.out.println("Hi Your Number is :" + number);
	}

	public String testDynamicRouter(Integer id) {

		if (id == 594629) {
			return "direct:venuroute";
		}
		if (id == 594628) {
			return "direct:ramaroute";
		}

		return "direct:defaultroute";
	}

	public void venuService(Integer number) {
		System.out.println("Hi Your Name venu / Number is :" + number);
	}

	public void ramaService(Integer number) {
		System.out.println("Hi Your Name rama / Number is :" + number);
	}

	public void defaultService(Integer number) {
		System.out.println("Hi Your Name default / Number is :" + number);
	}

}
