package com.ssafy.safefood;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.safefood.dto.User;
import com.ssafy.safefood.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class RepoTest {

	@Autowired
	UserRepository repo;
	
	@Test
	void test() {
		User user = new User("6at.hong@gmail.com","ssafy","박지홍","대둥");
		int a = repo.insertUser(user);
		assertEquals(a, 1);
		log.trace("is insertTest "+a);
	}

}
