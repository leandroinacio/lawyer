package com.leandro.lawyer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.leandro.lawyer.model.User;

public interface UserRepo extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
