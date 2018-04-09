package com.leandro.lawyer.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.leandro.lawyer.model.User;
import com.leandro.lawyer.security.Authority;
import com.leandro.lawyer.security.AuthorityName;
import com.leandro.lawyer.service.IUserService;

/**
 * @author Leandro Souza
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/user/")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	ApplicationEventPublisher eventPublisher;

	@PostMapping("fetchAll")
	public @ResponseBody ResponseEntity<List> fetchAll() {
		return new ResponseEntity<List>(userService.findAll(), HttpStatus.OK);
	}

	@PostMapping("fetchByUser")
	public @ResponseBody ResponseEntity<Object> fetchById(@RequestBody String username) {
		return new ResponseEntity<Object>(userService.findOne(username), HttpStatus.OK);
	}

	@PostMapping("insert")
	public @ResponseBody ResponseEntity<Object> insert(@RequestBody User user, WebRequest request) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		List<Authority> auth = new ArrayList<>();
		Authority aut = new Authority(null, AuthorityName.ROLE_USER);
		auth.add(aut);
		user.setPermissions(auth);
		user.setLastPasswordResetDate(new Date());
		return new ResponseEntity<Object>(userService.createUser(user), HttpStatus.OK);
//		try {
//	        eventPublisher.publishEvent(new OnRegistrationCompleteEvent
//	          (user, request.getLocale(), request.getContextPath()));
//	    } catch (Exception me) {
//	        return HttpStatus.INTERNAL_SERVER_ERROR;
//	    }
	}

	@PostMapping("update")
	public ResponseEntity<Object> update(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return new ResponseEntity<Object>(userService.updateUser(user), HttpStatus.OK);
	}

	@PostMapping("delete")
	public ResponseEntity<Object> delete(@RequestBody String username) {
		return new ResponseEntity<Object>(userService.deleteUser(username), HttpStatus.OK);
	}
	
}
