package com.leandro.lawyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leandro.lawyer.model.Owner;
import com.leandro.lawyer.repository.OwnerRepo;

/**
 * @author Leandro Souza
 */
@Controller
public class OwnerController {

	@Autowired
	private OwnerRepo ownerRepo;

	@PostMapping("/owner/fetchAll")
	public @ResponseBody Iterable<Owner> fetchAll() {
		return ownerRepo.findAll();
	}

	@PostMapping("/owner/fetchById")
	public @ResponseBody Owner fetchById(Long id) {
		return ownerRepo.findOne(id);
	}

	@PostMapping("/owner/insert")
	public @ResponseBody Owner insert(Owner owner) {
		return ownerRepo.save(owner);
	}

	@PostMapping("/owner/update")
	public @ResponseBody Boolean update(Long oldOwnerId, Owner owner) {
		Owner oldOne = ownerRepo.findOne(oldOwnerId);
		if (oldOne == null) {
			owner.setId(oldOwnerId);
			ownerRepo.save(owner);
			return true;
		}
		return false;
	}

	@PostMapping("/owner/delete")
	public @ResponseBody Boolean delete(Long id) {
		ownerRepo.delete(id);
		return true;
	}
}
