package com.spring.batch.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OracleDataSourceConfiguration {

	@Value("${spring.datasource.oracle.url}")
	private String url;

	@Value("&{spring.datasource.oracle.driver-class-name}")
	private String driver_className;

	@Bean
	DataSource dataSource() {
		return DataSourceBuilder.create().driverClassName(driver_className).url(url).username("system")
				.password("tiger").build();

	}

}
