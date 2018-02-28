package com.leandro.lawyer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.leandro.lawyer.model.User;
import com.leandro.lawyer.model.VerificationToken;

public interface VerificationTokenRepo extends MongoRepository<VerificationToken, Long> {
    
}
