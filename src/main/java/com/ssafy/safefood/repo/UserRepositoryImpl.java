package com.ssafy.safefood.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private final String namespace = "sql.safefood.";
	
	@Autowired
	SqlSession session;

	@Override
	public int insertUser(User user) {
		return session.insert(namespace+"restUserInsert", user);
	}

	@Override
	public User selectUser(String email) {
		return session.selectOne(namespace+"restUserSelect", email);
	}

	@Override
	public int updateUser(User user) {
		return session.update(namespace+"restUserUpdate", user);
	}

	@Override
	public int deleteUser(String email) {
		return session.delete(namespace+"restUserDelete", email);
	}
	
	
}
