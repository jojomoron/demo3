package com.example.demo.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

//@Repository
@RepositoryRestResource //RESTapi
//POST /books
//PUT /books/{bookid}
//GET /books/{bookid}
//DELETE /books/{bookid}
public interface BookRepository extends JpaRepository<Book, Integer>{

	// Prevents GET /books/:id
//    @Override
//    Book getOne(Integer id);
	
	// Prevents GET /books
    @Override
    Page<Book> findAll(Pageable pageable);
	
    // Prevents POST /books and PATCH /books/:id
    @Override
    Book save(Book s);

    // Prevents DELETE /books/:id
    @Override
    @RestResource(exported = false)
    void delete(Book t);
    
    
}
