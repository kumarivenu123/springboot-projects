package com.spring.boot.router;

import java.util.StringJoiner;

import org.apache.camel.RoutingSlip;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("direct:test").log("test service started...").to("bean:camelRouterService?method=testservice").end();

		// static route
		from("direct:teststatic").log("test static service started...").bean(CamelRouter.class, "staticRouter").end();

		from("direct:mytest1").log("test service started...").to("bean:camelRouterService?method=testStaticService1")
				.end();

		from("direct:mytest2").log("test service started...").to("bean:camelRouterService?method=testStaticService2")
				.end();

		from("direct:mytest3").log("test service started...").to("bean:camelRouterService?method=testStaticService3")
				.end();

		// dynamic route
		from("direct:testdynamic").log("test dynamic service started...")
				.recipientList(method("camelRouterService", "testDynamicRouter")).parallelProcessing().end();

		from("direct:venuroute").log("venu service started...").to("bean:camelRouterService?method=venuService").end();

		from("direct:ramaroute").log("rama service started...").to("bean:camelRouterService?method=ramaService").end();

		from("direct:defaultroute").log("default service started...")
				.to("bean:camelRouterService?method=defaultService").end();

	}

	@RoutingSlip
	public static String staticRouter() {
		StringJoiner router = new StringJoiner(",");
		router.add("direct:mytest1");
		router.add("direct:mytest2");
		router.add("direct:mytest3");
		return router.toString();
	}

}
