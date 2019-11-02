package com.springboot.practical.designs.example.libraryController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practical.designs.example.model.Book;
import com.springboot.practical.designs.example.model.Library;
import com.springboot.practical.designs.example.service.LibraryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/library/")
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	
	@ApiOperation(value = "Library Info", notes= "it contains all books")
	@GetMapping(value = "/lbraryInfo")
	public Iterable<Library> getLibraries() {
		return libraryService.feedDeafaultData();
	}
	
	@GetMapping("getBookwithId1")
	public Collection<Book> getBookwithId1() {
		return libraryService.getBookwithId1();
	}
	
	@GetMapping("getNumberOfBooks")
	public Collection<Book> getNumberOfBooks() {
		return libraryService.getNumberOfBooks();
	}
}
