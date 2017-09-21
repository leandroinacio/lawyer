package com.leandro.lawyer.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.lawyer.model.User;
import com.leandro.lawyer.repository.UserRepo;

/**
 * @author Leandro Souza
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/user")
public class UserController {

	//@Autowired
	//private ProfileRepo ownerRepo;

	/**@PostMapping("/owner/fetchAll")
	public @ResponseBody Iterable<Profile> fetchAll() {
		return ownerRepo.findAll();
	}

	@PostMapping("/owner/fetchById")
	public @ResponseBody Profile fetchById(@RequestBody Long id) {
		return ownerRepo.findOne(id);
	}
	
	@PostMapping("/owner/insert")
	public @ResponseBody Profile insert(@RequestBody Profile owner) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ownerRepo.save(owner);
	}

	@PostMapping("/owner/update")
	public @ResponseBody Boolean update(@RequestBody Profile owner) {
		//Profile oldOne = ownerRepo.findByLogin(owner.getUserName());
		if (oldOne != null) {
			ownerRepo.save(owner);
			return true;
		}
		return false;
	}

	@PostMapping("/owner/delete")
	public @ResponseBody Boolean delete(@RequestBody Long id) {
		ownerRepo.delete(id);
		return true;
	}**/
}
