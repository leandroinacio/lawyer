package com.leandro.lawyer.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RoleId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Module nome;

	@ManyToOne
	@JsonIgnore
	private Owner owner;

	@Override
	public String getAuthority() {
		return nome.toString();
	}

	public enum Module {
		ADMIN("ADMIN"), MANAGER("MANAGER"), USER("USER");
		private String module;

		private Module(String module) {
			this.module = module;
		}

		@Override
		public String toString() {
			return this.module;
		}
	}
}
