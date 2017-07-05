package com.leandro.lawyer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leandro.lawyer.model.Record;

@Repository
public interface RecordRepo extends CrudRepository<Record, Long> {

	@Query("SELECT r FROM Record r WHERE r.owner.id = ?1")
	Iterable<Record> findByOwner(Long id);

	@Query("SELECT r FROM Record r WHERE  r.owner.id = ?1 AND  r.recordType = ?2")
	Iterable<Record> findByOwnerAndType(Long ownerId, Integer recordType);
}
