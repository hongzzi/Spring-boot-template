package com.ssafy.safefood.service;

import com.ssafy.safefood.dto.User;

public interface UserService {
	
	User signin(String email, String password);
	int insertUser(User user);
	User selectUser(String email);
	int updateUser(User user);
	int deleteUser(String email);
}
