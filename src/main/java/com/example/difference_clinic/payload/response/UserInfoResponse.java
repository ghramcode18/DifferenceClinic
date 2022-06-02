package com.example.difference_clinic.payload.response;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class UserInfoResponse {
	private Long id;
	private String username;
	private List<String> roles;

	
	
	public UserInfoResponse(Long id, String username, List<String> roles) {
		this.id = id;
		this.username = username;
		this.roles = roles;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
