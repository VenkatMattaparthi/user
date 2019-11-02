package com.heraizen.pms.tms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping
	public List<UserDTO> allUsers() {
		return userService.allUsers();
		
	}
	@PutMapping
	public UserDTO updateUser(@RequestBody UserDTO userDto) {
		return userService.updateUser(userDto);
	}
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable String id) {
		return userService.deleteUser(id);
	}
}
