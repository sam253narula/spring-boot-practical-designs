package com.springboot.practical.designs.example.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//
//@Builder
//This class is sucessfully able to save in both tables but swagger is not able to parse it's response

@EqualsAndHashCode(exclude = "bookForBookCategory")
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookCategory  {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
    private Set<BookForBookCategory> bookForBookCategory;
    
    public BookCategory(String name, BookForBookCategory... bookForBookCategory) {
        this.name = name;
        this.bookForBookCategory = Stream.of(bookForBookCategory).collect(Collectors.toSet());
        this.bookForBookCategory.forEach(x -> x.setBookCategory(this));
    }
}
