package com.leandro.lawyer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.leandro.lawyer.model.User;
import com.leandro.lawyer.repository.UserRepo;

public class UserService implements IUserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	@Override
	public User createUser(User user) {
		return userRepo.insert(user);
	}

	@Override
	public Object updateUser(User user) {
		User toUpd = userRepo.findByUsername(user.getUsername());
		if (toUpd != null) {
			toUpd.setId(user.getId());
			return userRepo.save(toUpd);
		}
		return new Exception("User not found");
	}

	@Override
	public String deleteUser(String userName) {
		return userRepo.deleteByUsername(userName);
	}

	@Override
	public User findOne(String userName) {
		return userRepo.findByUsername(userName);
	}

//	@Override
//	public ResponseEntity<User> inactivateUser(String userName) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("userName").is(userName));
//	}

}
