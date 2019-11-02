package com.heraizen.pms.tms.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.heraizen.pms.tms.dto.UserDTO;

public interface UserService {
	public UserDTO register(UserDTO user) throws AlreadyUserExistsException;

	public UserDTO updateUser(UserDTO user);

	public Optional<UserDTO> userById(String id);

	public boolean deleteUser(String id);

	public List<UserDTO> allUsers();

	public List<UserDTO> search(Predicate<Boolean> search);
}
