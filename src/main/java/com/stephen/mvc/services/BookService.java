package com.stephen.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stephen.mvc.models.Book;
import com.stephen.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //Updates a book
    public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
    
    // Deletes
    public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}

}
