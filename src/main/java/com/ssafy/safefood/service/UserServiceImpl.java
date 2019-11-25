package com.ssafy.safefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dto.User;
import com.ssafy.safefood.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	
	@Override
	public User signin(String email, String password) {
		User user = repo.selectUser(email);
		if (password.equals(user.getPassWord())) {
			return user;
		} else {
			throw new RuntimeException("그런 사람 없어요 ~");
		}
	}
	
	@Override
	public int insertUser(User user) {
		return repo.insertUser(user);
	}

	@Override
	public User selectUser(String email) {
		return repo.selectUser(email);
	}

	@Override
	public int updateUser(User user) {
		return repo.updateUser(user);
	}

	@Override
	public int deleteUser(String email) {
		return repo.deleteUser(email);
	}


}
