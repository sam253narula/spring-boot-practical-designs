package com.springboot.practical.designs.example.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.practical.designs.example.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	@Query("SELECT b FROM Book b WHERE b.id = 1")
	Collection<Book> findAllid1Books();
	
	@Query("SELECT count(b) FROM Book b")
	Collection<Book> numberOfBooks();
	
	@Query(name = Book.FIND_BY_OID)
	Book findBookWithID(@Param("id") Long id);
	
	@Query("SELECT b FROM Book b WHERE b.library_id = :blablaid")
	List<Book> findBookByLibId(@Param("blablaid") Long id);
}



