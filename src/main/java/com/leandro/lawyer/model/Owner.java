package com.leandro.lawyer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Owners")
public class Owner {

	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty
	@Column(name = "Login", length = 50, unique = true)
	@Size(min = 4, max = 50)
	private String login;

	@Column(name = "Password", length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;
	
	@Column(name = "Name")
	private String name;

	@Column(name = "Title")
	private String title;

	@Column(name = "IsActive")
	private Boolean isActive;
	
	@Column(name = "Role")
	@NotNull
	private String role;
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(String login, String password, String name, String title, Boolean isActive, String role) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.title = title;
		this.isActive = isActive;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Owner [login=" + login + ", password=" + password + ", name=" + name + ", title=" + title
				+ ", isActive=" + isActive + ", role=" + role + "]";
	}
}
