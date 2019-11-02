package com.heraizen.pms.tms.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.heraizen.pms.tms.domain.User;
import com.heraizen.pms.tms.service.AlreadyUserExistsException;

public interface UserDaoService {
	public User register(User user) throws AlreadyUserExistsException;

	public User updateUser(User user);

	public Optional<User> userById(String id);

	public boolean deleteUser(String id);

	public List<User> allUsers();

	public List<User> search(Predicate<Boolean> search);
}
