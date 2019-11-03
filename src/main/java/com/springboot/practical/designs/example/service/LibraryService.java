package com.springboot.practical.designs.example.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.practical.designs.example.model.Book;
import com.springboot.practical.designs.example.model.Library;
import com.springboot.practical.designs.example.repository.BookRepository;
import com.springboot.practical.designs.example.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	LibraryRepository libraryRepository;

	@Autowired
	BookRepository bookRepo;

	public Iterable<Library> feedDeafaultData() {
		Book mobbyDick = Book.builder().id(12).title("Moby Dick").isbn("007").library_id(1).build();
		Book harryPotter = Book.builder().id(13).title("Harry Potter").isbn("008").library_id(1).build();
		// Book mobbyDick = new Book();
		// mobbyDick.setId(13);
		// mobbyDick.setTitle("Some Book");
		// mobbyDick.setIsbn("008");
		// mobbyDick.setLibrary_id(1);

		Library javaDiDukan = Library.builder().id(1).name("JavaDiDukan").books(Arrays.asList(mobbyDick, harryPotter))
				.build();
		libraryRepository.save(javaDiDukan);
		return libraryRepository.findAll();
	}

	public Collection<Book> getBookwithId1() {
		return bookRepo.findAllid1Books();
	}

	public Collection<Book> getNumberOfBooks() {
		return bookRepo.numberOfBooks();
	}

	public List<Book> getListOfBookByLibID(Long id) {
		return bookRepo.findBookByLibId(id);
	}
	
	public Library createNewLibrary(Library lib) {
		return libraryRepository.save(lib);
	}

}
