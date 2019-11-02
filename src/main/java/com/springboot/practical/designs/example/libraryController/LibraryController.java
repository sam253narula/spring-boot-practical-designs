package com.springboot.practical.designs.example.libraryController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practical.designs.example.model.Library;
import com.springboot.practical.designs.example.repository.LibraryRepository;
import com.springboot.practical.designs.example.service.LibraryService;

@RestController
@RequestMapping("/library/")
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	@GetMapping("/lbraryInfo")
	public Iterable<Library> getLibraries() {
		return libraryService.feedDeafaultData();
	}

}
