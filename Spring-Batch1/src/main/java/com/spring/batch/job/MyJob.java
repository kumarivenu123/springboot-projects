package com.spring.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.batch.MyProcessor;
import com.spring.batch.entity.Employee;
import com.spring.batch.reader.MyReader;
import com.spring.batch.writer.MyWriter;

@Configuration
@EnableBatchProcessing
public class MyJob {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final MyReader myReader;
	private final MyWriter myWriter;
	private final MyProcessor myProcessor;

	public MyJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, MyReader myReader,
			MyWriter myWriter, MyProcessor myProcessor) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
		this.myReader = myReader;
		this.myWriter = myWriter;
		this.myProcessor = myProcessor;

	}

	@Bean
	public Job empJob() throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {
		return jobBuilderFactory.get("empJob").incrementer(new RunIdIncrementer()).start(copyAllEmpDetails()).build();
	}

	@Bean
	@JobScope
	public Step copyAllEmpDetails() throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {
		return stepBuilderFactory.get("copyAllEmpDetails").<Employee, Employee>chunk(1).reader(myReader.read())
				.processor(myProcessor)/*.writer(myWriter)*/.faultTolerant().skip(Exception.class).noRetry(Exception.class)
				.noRollback(Exception.class).skipLimit(10).build();
	}

}
