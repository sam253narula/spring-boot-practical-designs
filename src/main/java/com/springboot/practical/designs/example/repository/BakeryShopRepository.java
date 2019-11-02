package com.springboot.practical.designs.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.practical.designs.example.model.Products;

@Repository
public interface BakeryShopRepository extends JpaRepository<Products, Serializable> {
	public Products findByItem(String item);
//	User findByFirstName(String firstName);
//
//	User findBySalary(Integer salary);
//
//	User findByFirstNameAndLastName(String firstName, String lastName);
//
//	User findByFirstNameOrLastName(String firstName, String lastName);
	
}
