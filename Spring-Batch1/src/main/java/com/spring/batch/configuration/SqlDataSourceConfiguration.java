package com.spring.batch.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SqlDataSourceConfiguration {

	@Value("${spring.datasource.sql.driver-class-name}")
	private String sqlClassname;

	@Value("${spring.datasource.sql.url}")
	private String sqlUrl;

	@Bean
	@Primary
	DataSource sqlDataSource() {
		return DataSourceBuilder.create().driverClassName(sqlClassname).password("system").username("tiger").url(sqlUrl)
				.build();
	}

}
