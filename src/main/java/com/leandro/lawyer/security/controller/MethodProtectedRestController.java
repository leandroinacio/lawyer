package com.leandro.lawyer.security.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.lawyer.model.User;
import com.leandro.lawyer.repository.UserRepo;
import com.leandro.lawyer.security.Authority;
import com.leandro.lawyer.security.AuthorityName;

@RestController
@RequestMapping("protected")
public class MethodProtectedRestController {

	@Autowired
	public UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * This is an example of some different kinds of granular restriction for
	 * endpoints. You can use the built-in SPEL expressions in @PreAuthorize
	 * such as 'hasRole()' to determine if a user has access. Remember that the
	 * hasRole expression assumes a 'ROLE_' prefix on all role names. So 'ADMIN'
	 * here is actually stored as 'ROLE_ADMIN' in database!
	 **/
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/getGreeting")
	public ResponseEntity<?> getProtectedGreeting() {
		return ResponseEntity.ok("Greetings from admin protected method!");
	}

	@PostMapping("/unprotected")
	public @ResponseBody String fetchAll(@RequestBody User user) {
		List<Authority> list = new ArrayList<>();
		Authority aut = new Authority(0L, AuthorityName.ROLE_ADMIN);
		list.add(aut);
		user.setAuthorities(list);
		user.setLastPasswordResetDate(new Date());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return "funcionou";
	}

	@PostMapping("/getUser")
	public @ResponseBody User getUser() {
		List<Authority> list = new ArrayList<>();
		Authority aut = new Authority(0L, AuthorityName.ROLE_ADMIN);
		list.add(aut);
		return new User("", "leandro", "teste", "leandro", "Inacio", "email@mail", true, new Date(), list);
	}

}