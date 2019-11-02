package com.heraizen.pms.tms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heraizen.pms.tms.dto.UserDTO;
import com.heraizen.pms.tms.service.AlreadyUserExistsException;
import com.heraizen.pms.tms.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userServic) {
		this.userService = userServic;
	}

	@PostMapping
	public UserDTO registerUser(@RequestBody UserDTO userDTO) throws AlreadyUserExistsException {
		userDTO= userService.register(userDTO);
		return userDTO;
	}
}
