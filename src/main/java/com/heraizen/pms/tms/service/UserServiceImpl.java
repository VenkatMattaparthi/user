package com.heraizen.pms.tms.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.heraizen.pms.tms.dao.UserDaoService;
import com.heraizen.pms.tms.domain.User;
import com.heraizen.pms.tms.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	private UserDaoService userDaoService;
	@Autowired
	private ModelMapper modelMapper;
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	public UserServiceImpl(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}

	@Override
	public UserDTO register(UserDTO userDto) throws AlreadyUserExistsException {
		Assert.notNull(userDto, "UserDto can't be null");
		LOG.info("User registered with {}:");
		User user = modelMapper.map(userDto, User.class);
		user = userDaoService.register(user);
		userDto = modelMapper.map(user, UserDTO.class);
		return userDto;
	}

	@Override
	public UserDTO updateUser(UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserDTO> userById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserDTO> allUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> search(Predicate<Boolean> search) {
		// TODO Auto-generated method stub
		return null;
	}

}
