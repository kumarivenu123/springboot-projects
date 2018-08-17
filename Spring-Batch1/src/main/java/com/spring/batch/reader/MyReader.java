package com.spring.batch.reader;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.spring.batch.entity.Employee;

@Component
public class MyReader {

	private final DataSource mySqlDataSource;
	private final Properties sqlProperties;

	public MyReader(@Qualifier("mySqlDataSource") DataSource mySqlDataSource, Properties sqlProperties) {
		this.mySqlDataSource = mySqlDataSource;
		this.sqlProperties = sqlProperties;
	}

	public ItemReader<Employee> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		JdbcCursorItemReader<Employee> databaseReader = new JdbcCursorItemReader<>();
		databaseReader.setDataSource(mySqlDataSource);
		databaseReader.setSql(sqlProperties.getProperty("selectQuery"));
		databaseReader.setRowMapper(new BeanPropertyRowMapper<>(Employee.class));
		return databaseReader;
	}

}
