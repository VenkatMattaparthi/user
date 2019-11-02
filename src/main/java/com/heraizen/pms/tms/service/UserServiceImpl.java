package com.heraizen.pms.tms.service;

import java.util.ArrayList;
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
	public UserDTO updateUser(UserDTO userDto) {
		Assert.notNull(userDto, "User shouldn't be null");
		Assert.notNull(userDto.getId(), "User id shouldn't null");
		User user = modelMapper.map(userDto, User.class);
	     user = userDaoService.updateUser(user);
	     userDto = modelMapper.map(user, UserDTO.class);
		LOG.info("User with id : {} is updated successfully", userDto.getId());
		return userDto;
	}

	@Override
	public Optional<UserDTO> userById(String id) {
		Optional<User> user = userDaoService.userById(id);
		UserDTO userDto = modelMapper.map(user, UserDTO.class);
		return null;
	}

	@Override
	public boolean deleteUser(String id) {
		boolean isdel = userDaoService.deleteUser(id);
		if(isdel) {
			LOG.info("User with id {} has been deleted"+id);
			return true;
		}
		else {
			LOG.info("User coudn't be delete");
			return false;
		}
		
	}

	@Override
	public List<UserDTO> allUsers() {
		List<User> users = userDaoService.allUsers();
		LOG.info("List of user size{}:"+users.size());
		List<UserDTO> dtos=new ArrayList<>();
		for (User user : users) {
			UserDTO userdto = modelMapper.map(user, UserDTO.class);
			dtos.add(userdto);
		}
		return dtos;
	}

	@Override
	public List<UserDTO> search(Predicate<Boolean> search) {
		// TODO Auto-generated method stub
		return null;
	}

}
