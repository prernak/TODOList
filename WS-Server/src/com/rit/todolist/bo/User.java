package com.rit.todolist.bo;

public class User {

	private String name;
	private String password;
	private String id;

	public String getUsername() {
		return name;
	}
	
	public void setUsername(String username) {
		this.name = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
		
}
