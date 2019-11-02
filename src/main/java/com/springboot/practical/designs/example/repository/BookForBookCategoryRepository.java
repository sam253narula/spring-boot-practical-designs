package com.springboot.practical.designs.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.practical.designs.example.model.BookCategory;

@Repository
public interface BookForBookCategoryRepository extends JpaRepository<BookCategory, Integer> {

}
