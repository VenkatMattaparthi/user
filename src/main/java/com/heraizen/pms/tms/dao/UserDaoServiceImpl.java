package com.heraizen.pms.tms.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heraizen.pms.tms.domain.User;
import com.heraizen.pms.tms.repo.UserRepo;
import com.heraizen.pms.tms.service.AlreadyUserExistsException;

@Repository
public class UserDaoServiceImpl implements UserDaoService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User register(User user) throws AlreadyUserExistsException {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> userById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> allUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> search(Predicate<Boolean> search) {
		// TODO Auto-generated method stub
		return null;
	}

}
