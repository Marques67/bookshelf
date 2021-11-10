package com.example.lucas.bookShelf.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer cpf;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String password;

	public Client() {
	}

	public Client(Integer cpf, @NotEmpty String name, @NotEmpty String email, @NotEmpty String password) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
