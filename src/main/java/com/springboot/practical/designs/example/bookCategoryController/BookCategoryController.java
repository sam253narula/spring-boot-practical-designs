package com.springboot.practical.designs.example.bookCategoryController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practical.designs.example.model.BookCategory;
import com.springboot.practical.designs.example.serviceImpl.BookCategoryService;

@RestController
public class BookCategoryController {

	
	@Autowired
	BookCategoryService bookCategoryService;
	
	@GetMapping(path = "allBookCategories", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookCategory> getAllBooks(){
		return bookCategoryService.getAllBooks();
		
	}
}
