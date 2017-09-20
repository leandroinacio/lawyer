package com.leandro.lawyer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leandro.lawyer.model.Profile;

@Repository
public interface OwnerRepo extends CrudRepository<Profile, Long> {
	
	@Query("SELECT o FROM Owner o WHERE o.login = ?1")
	Profile findByLogin(String login);

}
