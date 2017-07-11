package com.leandro.lawyer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leandro.lawyer.model.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {

}
