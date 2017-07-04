package com.leandro.lawyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leandro.lawyer.model.Record;
import com.leandro.lawyer.repository.RecordRepo;

/**
 * @author Leandro Souza
 */
@Controller
public class RecordController {

	@Autowired
	private RecordRepo recordRepo;

	@PostMapping("/record/fetchAll")
	public @ResponseBody Iterable<Record> fetchAll() {
		return recordRepo.findAll();
	}

	@PostMapping("/record/fetchByOwner")
	public @ResponseBody Iterable<Record> fetchByOwner(Long ownerId) {
		return recordRepo.findByOwner(ownerId);
	}

	@PostMapping("/record/fetchByOwnerAndType")
	public @ResponseBody Iterable<Record> fetchByOwner(Long ownerId, Integer recordType) {
		return recordRepo.findByOwnerAndType(ownerId, recordType);
	}

	@PostMapping("/record/insert")
	public @ResponseBody Record insert(Record record) {
		return recordRepo.save(record);
	}

	@PostMapping("/record/update")
	public @ResponseBody Boolean update(Record record) {
		Record oldOne = recordRepo.findOne(record.getId());
		if (oldOne != null) {
			recordRepo.save(record);
			return true;
		}
		return false;
	}

	@PostMapping("/record/delete")
	public @ResponseBody Boolean delete(Long id) {
		recordRepo.delete(id);
		return true;
	}

}
