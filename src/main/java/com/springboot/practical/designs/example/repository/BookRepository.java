package com.springboot.practical.designs.example.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.practical.designs.example.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	@Query("SELECT b FROM Book b WHERE b.id = 1")
	Collection<Book> findAllid1Books();
	
	@Query("SELECT count(b) FROM Book b")
	Collection<Book> numberOfBooks();
}
