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

import com.leandro.lawyer.events.OnRegistrationCompleteEvent;
import com.leandro.lawyer.model.User;
import com.leandro.lawyer.repository.UserRepo;
import com.leandro.lawyer.security.Authority;
import com.leandro.lawyer.security.AuthorityName;

/**
 * @author Leandro Souza
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	ApplicationEventPublisher eventPublisher;

	@PostMapping("/fetchAll")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody Iterable<User> fetchAll() {
		return userRepo.findAll();
	}

	@PostMapping("/fetchById")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody User fetchById(@RequestBody String username) {
		return userRepo.findByUsername(username);
	}

	@PostMapping("/insert")
	//@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody HttpStatus insert(@RequestBody User user, WebRequest request) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		List<Authority> auth = new ArrayList<>();
		Authority aut = new Authority(null, AuthorityName.ROLE_USER);
		auth.add(aut);
		user.setAuthorities(auth);
		user.setLastPasswordResetDate(new Date());
		user = userRepo.save(user);
		try {
	        eventPublisher.publishEvent(new OnRegistrationCompleteEvent
	          (user, request.getLocale(), request.getContextPath()));
	    } catch (Exception me) {
	        return HttpStatus.INTERNAL_SERVER_ERROR;
	    }
		
		return HttpStatus.OK;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody User updates) {
		User user = userRepo.findByUsername(updates.getUsername());
		if (user != null) {
			updates.setPassword(passwordEncoder.encode(updates.getPassword()));
			updates.setId(user.getId());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/owner/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@RequestBody Long id) {
		userRepo.delete(id);
		return ResponseEntity.ok().build();
	}
}
