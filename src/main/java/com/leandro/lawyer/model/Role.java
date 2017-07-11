package com.leandro.lawyer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Roles")
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
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, Module nome, Owner owner) {
		super();
		this.id = id;
		this.nome = nome;
		this.owner = owner;
	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Module getNome() {
		return nome;
	}

	public void setNome(Module nome) {
		this.nome = nome;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", nome=" + nome + ", owner=" + owner + "]";
	}
		
}
