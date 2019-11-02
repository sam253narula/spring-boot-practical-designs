package com.springboot.practical.designs.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.practical.designs.example.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
