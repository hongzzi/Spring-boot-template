package com.ssafy.safefood.service;

import java.util.Map;

import com.ssafy.safefood.dto.User;

public interface JwtService {
	
	String create(final User user);
	void checkValid(final String jwt);
	Map<String, Object> get(final String jwt);
}
