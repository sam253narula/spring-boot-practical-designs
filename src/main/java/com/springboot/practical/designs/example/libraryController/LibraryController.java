package com.springboot.practical.designs.example.libraryController;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practical.designs.example.model.Book;
import com.springboot.practical.designs.example.model.Library;
import com.springboot.practical.designs.example.service.LibraryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	
	@ApiOperation(value = "Library Info", notes= "it contains all books")
	@GetMapping(value = "/lbraryInfo")
	public Iterable<Library> getLibraries() {
		return libraryService.feedDeafaultData();
	}
	
	@GetMapping("/getBookwithId1")
	public Collection<Book> getBookwithId1() {
		return libraryService.getBookwithId1();
	}
	
	@GetMapping("/getNumberOfBooks")
	public Collection<Book> getNumberOfBooks() {
		return libraryService.getNumberOfBooks();
	}
	
	@GetMapping("/getListOfBookByLibID/{id}")
	public List<Book> getListOfBookByLibID(@PathVariable Long id) {
		return libraryService.getListOfBookByLibID(id);
	}
	
	@ApiOperation(value = "Library", notes= "Stores the Book details in Repository")
	@PostMapping(value = "/createNewLibrary", consumes= MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Library Details stored in repo")})
	public ResponseEntity<Library> createNewLibrary (@RequestBody Library lib) {
		return new ResponseEntity<>(libraryService.createNewLibrary(lib), HttpStatus.CREATED);
	}
}
