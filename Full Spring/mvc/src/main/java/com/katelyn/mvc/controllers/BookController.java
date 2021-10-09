package com.katelyn.mvc.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/books/new.jsp";
	}
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		System.out.println("hi");
		if(result.hasErrors()) {
			return"/books/new.jsp";
		} else {
			bookservice.createBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookservice.findBook(id);
		model.addAttribute("book", book);
		return "/books/edit.jsp";
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "/books/edit.jsp";
		} else {
			bookservice.createBook(book);
			return "redirect:/books";
		}
	}
	
	@DeleteMapping("/books/{id}/delete")
	public String deleteBook(@PathVariable("id") Long id) {
		bookservice.deleteBook(id);
		
		return "redirect:/books";
	}
	
	
}
