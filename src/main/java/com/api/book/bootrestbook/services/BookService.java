package com.api.book.bootrestbook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.model.Book;
import com.api.book.bootrestbook.repo.BookRepository;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}


	public Book getBookById(int id) {
	    Book book = null;
	    try {
	        book = this.bookRepository.findById(id).orElse(null);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return book;
	}


	// Adding book
	public Book addBook(Book book) {
//    	list.add(book);
		Book result = bookRepository.save(book);
		return result;
	}

	// Delete book
	public void deleteBook(int bookId) {

//    	list = list.stream().filter( book -> book.getId()!=bookId).collect(Collectors.toList()); 
		bookRepository.deleteById(bookId);

	}

//	public void updateBook(Book book, int bookId) {
//
//
//		bookRepository.save(book);
//
//	}
	public void updateBook(Book book, int bookId) {
	    Optional<Book> existingBook = bookRepository.findById(bookId);

	    if (existingBook.isPresent()) {
	        Book bookToUpdate = existingBook.get();
	        bookToUpdate.setTitle(book.getTitle());  // Update fields
	        bookToUpdate.setAuthor(book.getAuthor());

	        bookRepository.save(bookToUpdate); // Save the updated book
	    } else {
	        throw new RuntimeException("Book with ID " + bookId + " not found!");
	    }
	}


}
