package com.leandro.lawyer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.leandro.lawyer.model.User;

public interface UserRepo extends MongoRepository<User, Long> {
    User findByUsername(String username);
        
    
    List<User> findAll();
    
//    @Query("{ 'name' : ?0 }")
//    List<User> findUsersByName(String name);
}
