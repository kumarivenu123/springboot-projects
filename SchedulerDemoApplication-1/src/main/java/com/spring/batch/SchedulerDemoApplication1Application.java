package com.spring.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SchedulerDemoApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerDemoApplication1Application.class, args);
	}
}
