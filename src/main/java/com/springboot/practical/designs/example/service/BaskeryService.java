package com.springboot.practical.designs.example.service;

import java.util.List;

import com.springboot.practical.designs.example.model.Products;

public interface BaskeryService {

	List<Products> getAllProducts();

	int totalBill(List<Products> products);

}