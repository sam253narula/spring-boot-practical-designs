package com.springboot.practical.designs.example.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practical.designs.example.model.BookCategory;
import com.springboot.practical.designs.example.model.BookForBookCategory;
import com.springboot.practical.designs.example.repository.BookCategoryRepository;

@Service
public class BookCategoryService {

	@Autowired
	BookCategoryRepository bookCategoryRepository;
	
	public List<BookCategory> getAllBooks(){
//		BookCategory arg0 = BookCategory.builder().name("Adventure")
//				.bookForBookCategory(Arrays.asList(BookForBookCategory.builder().name("lost in amazon").build())).build();
//		//.bookCategory(BookCategory.builder().id(1).build())
		 // Create a couple of Book and BookCategory
        bookCategoryRepository.save(new BookCategory("Category 1", new BookForBookCategory("Hello Koding 1"), new BookForBookCategory("Hello Koding 2")));
		return bookCategoryRepository.findAll();
		
		
	}
}
