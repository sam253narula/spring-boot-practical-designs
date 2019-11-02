package com.springboot.practical.designs.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.practical.designs.example.model.Library;

public interface LibraryRepository extends CrudRepository<Library, Long> {

}
