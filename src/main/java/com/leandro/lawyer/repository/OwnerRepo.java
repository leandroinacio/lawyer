package com.leandro.lawyer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leandro.lawyer.model.Owner;

@Repository
public interface OwnerRepo extends CrudRepository<Owner, Long> {

}
