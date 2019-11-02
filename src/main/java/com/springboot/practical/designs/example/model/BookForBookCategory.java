package com.springboot.practical.designs.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookForBookCategory {
	
	public BookForBookCategory(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	@ManyToOne
	@JoinColumn
	private BookCategory bookCategory;
}
