package com.ssafy.safefood.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value="user")
public class User {

	private String email;
	private String passWord;
	private String name;
	private String allergy;
	
	public User(String email, String passWord, String name, String allergy) {
		super();
		this.email = email;
		this.passWord = passWord;
		this.name = name;
		this.allergy = allergy;
	}
	
}
