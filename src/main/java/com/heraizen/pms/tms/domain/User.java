package com.heraizen.pms.tms.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
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
