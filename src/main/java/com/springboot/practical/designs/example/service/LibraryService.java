package com.springboot.practical.designs.example.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practical.designs.example.model.Book;
import com.springboot.practical.designs.example.model.Library;
import com.springboot.practical.designs.example.repository.BookRepository;
import com.springboot.practical.designs.example.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	LibraryRepository libraryRepository;

	@Autowired
	BookRepository bookRepository;

	public Iterable<Library> feedDeafaultData() {
		Book mobbyDick = Book.builder().id(12).title("Moby Dick").isbn("007").library_id(1).build();
		
//		Book mobbyDick = new Book();
//		mobbyDick.setId(13);
//		mobbyDick.setTitle("Some Book");
//		mobbyDick.setIsbn("008");
//		mobbyDick.setLibrary_id(1);

		Library javaDiDukan = Library.builder().id(1).name("JavaDiDukan").books(Arrays.asList(mobbyDick)).build();
		libraryRepository.save(javaDiDukan);
		return libraryRepository.findAll();
	}

}
