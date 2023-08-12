package com.AariyanSahu.chatapp.dto;
//DATA TRANSFER OBJECT

public class UserDTO {
	private String userId;
	private char[] password;
	
	public UserDTO(String userId, char[] password) {
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
	
}
