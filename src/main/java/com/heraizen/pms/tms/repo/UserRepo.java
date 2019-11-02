package com.heraizen.pms.tms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.heraizen.pms.tms.domain.User;

public interface UserRepo extends MongoRepository<User, String>{

}
