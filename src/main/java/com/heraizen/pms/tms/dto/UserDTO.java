package com.heraizen.pms.tms.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.heraizen.pms.tms.domain.Role;
import com.heraizen.pms.tms.domain.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@Id
	private String id;
	private String fullname;
	private String shortname;
	private String username;
	private String password;
	private LocalDateTime registered_date;
	private Role role;
	private UserStatus user;

}
