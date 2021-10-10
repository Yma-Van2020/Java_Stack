package com.katelyn.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.katelyn.authentication.models.Book;
import com.katelyn.authentication.repos.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public Book getBookById(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else return null;
	}
	
	public Book saveBook(Book b) {
		return bookRepo.save(b);
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}

}
