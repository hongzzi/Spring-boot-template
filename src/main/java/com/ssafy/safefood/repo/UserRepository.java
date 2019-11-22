package com.ssafy.safefood.repo;

import com.ssafy.safefood.dto.User;

public interface UserRepository {

	int insertUser(User user);
	User selectUser(String email);
	int updateUser(User user);
	int deleteUser(String email);
}
