package com.example.lucas.bookShelf.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Books implements Serializable {

	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private String author;
	
	@Min(0)
	private int numberOfPages;
	
	public Books() {
	}

	public Books(int code, String name, String description, String author, int numberOfPages) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.author = author;
		this.numberOfPages = numberOfPages;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
}
