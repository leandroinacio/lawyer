package com.leandro.lawyer.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.leandro.lawyer.enums.RecordName;

public class RecordType {

	@Id
	private Long id;

	@NotNull
	private RecordName name;

	public RecordType(Long id, RecordName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RecordName getName() {
		return name;
	}

	public void setName(RecordName name) {
		this.name = name;
	}
}
