package com.leandro.lawyer.service;

import java.util.List;

import com.leandro.lawyer.model.User;

public interface IUserService {
	public List<User> findAll();
	public User findOne(String userName);
	public User createUser(User user);
	public Object updateUser(User user);
	public String deleteUser(String userName);
}
