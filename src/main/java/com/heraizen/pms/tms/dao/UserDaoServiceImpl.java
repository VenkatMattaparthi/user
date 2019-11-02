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
		user=userRepo.save(user);
		return user;
	}

	@Override
	public Optional<User> userById(String id) {
		return userRepo.findById(id);
	}

	@Override
	public boolean deleteUser(String id) {
		 Optional<User> user = userRepo.findById(id);
		 if (user.isPresent()) {
				userRepo.delete(user.get());
				return true;
			}
		return false;
	}

	@Override
	public List<User> allUsers() {
		return userRepo.findAll();
	}

	@Override
	public List<User> search(Predicate<Boolean> search) {
		// TODO Auto-generated method stub
		return null;
	}

}
