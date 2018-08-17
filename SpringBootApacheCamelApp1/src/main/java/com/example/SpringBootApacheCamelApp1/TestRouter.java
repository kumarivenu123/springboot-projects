package com.example.SpringBootApacheCamelApp1;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("direct:findempidroute").log("Calling Employee id router...").to("bean:testService?method=setEmployeId")
				.end();
		
		from("direct:sendmail").log("Calling Employee mail router...").to("bean:sendingMail?method=sendMail").end();

	}

}
