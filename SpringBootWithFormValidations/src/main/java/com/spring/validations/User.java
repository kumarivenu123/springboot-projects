package com.spring.validations;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@NotNull(message = "User name should not be null")
	@NotEmpty(message = "User name should not be not Empty")
	@Size(min = 4, max = 10, message = "User name should be 4 to 10 characters")
	private String userName;

	@NotNull(message = "User name should not be null")
	@NotEmpty(message = "User name should not be not Empty")
	@Size(min = 4, max = 10, message = "User name should be 4 to 10 characters")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@NotNull @NotEmpty String userName, @NotNull @NotEmpty String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}
