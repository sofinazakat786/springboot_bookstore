package com.api.book.bootrestbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.book.bootrestbook.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

//	public Book findById(int id);
//
//	public Book findAllBooks();

}
