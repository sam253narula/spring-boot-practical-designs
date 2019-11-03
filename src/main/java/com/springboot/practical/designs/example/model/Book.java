package com.springboot.practical.designs.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
//(name = "Book")
@NamedQueries({
	@NamedQuery(name = Book.FIND_BY_OID, query = "SELECT b FROM Book b WHERE b.id = :id")
})
public class Book {
	
	public static final String FIND_BY_OID = "Book.FIND_BY_OID";
	
	@Id
	private long id;

	@Column(nullable = false)
	private String title;

	private String isbn;

	private long library_id;
	
}

//@ManyToOne
//private List<Library> library;


//(mappedBy = "library", cascade = CascadeType.ALL)
// @ManyToOne(optional =false, fetch =FetchType.LAZY)
// @JoinColumn(name="library_id", nullable = false)
// private Library library;
