package com.leandro.lawyer.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.leandro.lawyer.model.Record;

public interface RecordRepo extends MongoRepository<Record, Long> {
}
