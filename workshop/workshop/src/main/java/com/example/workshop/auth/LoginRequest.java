package com.example.workshop.auth;

public class LoginRequest{
	private String password;
	private String username;

	public LoginRequest() {
	}

	public LoginRequest(String password, String username) {
		this.password = password;
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
