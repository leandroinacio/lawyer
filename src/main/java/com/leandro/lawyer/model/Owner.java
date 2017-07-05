package com.leandro.lawyer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.mapping.Collection;

@Entity
@Table(name = "Owners")
public class Owner {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "OwnerId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Title")
	private String title;

	public Owner() {
		super();
	}

	public Owner(Long id, String name, String title, Collection records) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", title=" + title + "]";
	}
}
