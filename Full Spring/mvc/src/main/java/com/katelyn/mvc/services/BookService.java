package com.katelyn.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.katelyn.mvc.models.Book;
import com.katelyn.mvc.repos.BookRepos;

@Service
public class BookService {
	private final BookRepos bookRepos;
	
	public BookService(BookRepos bookRepos) {
		this.bookRepos = bookRepos;
	}
	
	//return all the books
	public List<Book> allBooks(){
		return bookRepos.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepos.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepos.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Long id, String title, String description, String language, Integer pages) {
		Optional<Book> optionalBook = bookRepos.findById(id);
		
		if(optionalBook.isPresent()) {
			Book book = optionalBook.get();
			
		book.setTitle(title);
		book.setLanguage(language);
		book.setDescription(description);
		book.setNumberOfPages(pages);
		return bookRepos.save(book);
		}
		
		return null;
	}
	
	public void deleteBook(Long id) {
		bookRepos.deleteById(id);
	}


}
