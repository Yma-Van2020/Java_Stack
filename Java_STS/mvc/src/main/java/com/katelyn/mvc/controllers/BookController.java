package com.katelyn.mvc.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.katelyn.mvc.models.Book;
import com.katelyn.mvc.services.BookService;

@Controller
public class BookController {

	@Autowired //does the dependency injection 
	BookService bookservice;
	
	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		System.out.println(bookId);
		Book book = bookservice.findBook(bookId);
		System.out.println(book);
		
		model.addAttribute("book", book);
		
		
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		ArrayList<Book> books = (ArrayList<Book>) bookservice.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
}
