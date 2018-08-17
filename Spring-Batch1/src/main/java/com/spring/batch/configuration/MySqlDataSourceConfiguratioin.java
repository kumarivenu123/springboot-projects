package com.spring.batch.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySqlDataSourceConfiguratioin {

	@Value("${spring.datasource.mysql.driver-class-name}")
	private String mySqlClassname;

	@Value("${spring.datasource.mysql.url}")
	private String mySqlUrl;

	@Bean
	DataSource mySqlDataSource() {
		return DataSourceBuilder.create().driverClassName(mySqlClassname).password("venu").username("root")
				.url(mySqlUrl).build();
	}

}
