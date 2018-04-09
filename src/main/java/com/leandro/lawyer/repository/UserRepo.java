package com.leandro.lawyer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.leandro.lawyer.model.User;

public interface UserRepo extends MongoRepository<User, Long> {
    User findByUsername(String username);
        
    
    List<User> findAll();
    
    @Transactional
    String deleteByUsername(String username);
    
//    @Query("{ 'name' : ?0 }")
//    List<User> findUsersByName(String name);
}
