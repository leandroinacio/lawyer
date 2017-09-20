package com.leandro.lawyer.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Profiles")
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty
	@Column(unique = true)
	@Size(min = 4, max = 50)
	private String userName;

    @NotNull
    private String password;
		
	@NotNull
	private String[] roles;
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(String userName, String password, String[] roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Profile [userName=" + userName + ", password=" + password + ", roles=" + Arrays.toString(roles) + "]";
	}
}
