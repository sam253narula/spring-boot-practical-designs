package com.springboot.practical.designs.example.libraryController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practical.designs.example.model.Book;
import com.springboot.practical.designs.example.model.Library;
import com.springboot.practical.designs.example.repository.BookRepository;
import com.springboot.practical.designs.example.service.LibraryService;

@RestController
@RequestMapping("/library/")
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	
	@Autowired
	BookRepository bookRepo;

	@GetMapping("/lbraryInfo")
	public Iterable<Library> getLibraries() {
		return libraryService.feedDeafaultData();
	}
	
	@GetMapping("getBookwithId1")
	public Collection<Book> getBookwithId1() {
		return bookRepo.findAllid1Books();
	}
	
	@GetMapping("getNumberOfBooks")
	public Collection<Book> getNumberOfBooks() {
		return bookRepo.numberOfBooks();
	}
}
