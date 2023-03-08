package com.example.share.enums;

public enum Roles {

	ROLE_ADMIN("ADMIN"),
	ROLE_USER("USER");
	
	private String role;
	Roles(String role){
		this.role=role;
	}
	
	public String getRole() {
		return "ROLE_"+role;
	}
	
	@Override
	public String toString() {
		return role;
	}
}
