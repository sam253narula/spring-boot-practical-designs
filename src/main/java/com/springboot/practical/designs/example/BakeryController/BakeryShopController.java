package com.springboot.practical.designs.example.BakeryController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practical.designs.example.model.Products;
import com.springboot.practical.designs.example.service.BaskeryService;

@RestController
@RequestMapping("/bakeryShop/")
public class BakeryShopController {
	
	@Autowired
	BaskeryService bakeryService;
	
	@GetMapping("/allProducts")
	public List<Products> getAllProducts(){
	return bakeryService.getAllProducts();
	}
	
	@PostMapping("/productsToPurchase")
	public int userWantsToPurchase(@RequestBody List<Products> products){
		return bakeryService.totalBill(products);
	}
	
}
