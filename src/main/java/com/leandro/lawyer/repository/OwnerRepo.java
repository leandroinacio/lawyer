package com.leandro.lawyer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leandro.lawyer.model.Owner;

@Repository
public interface OwnerRepo extends CrudRepository<Owner, Long> {

	@Query("SELECT o FROM Owner o WHERE o.login = ?1 AND o.password = ?2")
	Owner authenticate(String login, String password);

}
