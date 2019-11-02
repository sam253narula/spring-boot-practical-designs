package com.springboot.practical.designs.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practical.designs.example.model.Products;
import com.springboot.practical.designs.example.repository.BakeryShopRepository;
import com.springboot.practical.designs.example.service.BaskeryService;

@Service
public class BakeryServiceImpl implements BaskeryService {
	
	@Autowired
	BakeryShopRepository bakeryShopRepository;
	
	/* (non-Javadoc)
	 * @see com.springboot.parkinglot.example.service.BaskeryServiceInter#getAllProducts()
	 */
	@Override
	public List<Products> getAllProducts() {
		
		return bakeryShopRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.springboot.parkinglot.example.service.BaskeryServiceInter#totalBill(java.util.List)
	 */
	@Override
	public int totalBill(List<Products> products) {
		int price =0;
		for(Products product : products) {
			price = price +	product.getPrice();
		}
		return price;
	}

}
