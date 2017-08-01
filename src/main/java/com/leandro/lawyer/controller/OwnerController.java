package com.leandro.lawyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.lawyer.model.Owner;
import com.leandro.lawyer.repository.OwnerRepo;

/**
 * @author Leandro Souza
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OwnerController {

	@Autowired
	private OwnerRepo ownerRepo;

	@PostMapping("/owner/fetchAll")
	public @ResponseBody Iterable<Owner> fetchAll() {
		return ownerRepo.findAll();
	}

	@PostMapping("/owner/fetchById")
	public @ResponseBody Owner fetchById(@RequestBody Long id) {
		return ownerRepo.findOne(id);
	}
	
	@PostMapping("/owner/insert")
	public @ResponseBody Owner insert(@RequestBody Owner owner) {
		return ownerRepo.save(owner);
	}

	@PostMapping("/owner/update")
	public @ResponseBody Boolean update(@RequestBody Owner owner) {
		Owner oldOne = ownerRepo.findByLogin(owner.getLogin());
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
	}
}
