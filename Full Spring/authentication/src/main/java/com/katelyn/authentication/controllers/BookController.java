package com.katelyn.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.katelyn.authentication.models.Book;
import com.katelyn.authentication.models.User;
import com.katelyn.authentication.services.BookService;
import com.katelyn.authentication.services.UserService;

@Controller
public class BookController {

	@Autowired 
	BookService bookServ;
	
	@Autowired 
	UserService userServ;
	
	// ========== Display =======================
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		Long userid = (Long) session.getAttribute("user_id");
    	if (userid == null) {
    		return "redirect:/";
    	}
		User postedBy = userServ.getUserById(userid);
		model.addAttribute("postedBy", postedBy);
		
			return "add.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userid = (Long) session.getAttribute("user_id");
    	if (userid == null) {
    		return "redirect:/";
    	}
    	
    	Book book = bookServ.getBookById(id);
    	model.addAttribute("book", book);
    	return "ViewBook.jsp";
	}
	
	
	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userid = (Long) session.getAttribute("user_id");
    	if (userid == null) {
    		return "redirect:/";
    	}
    	
		Book book = bookServ.getBookById(id);
		model.addAttribute("book", book);
		return "EditBook.jsp";
	}
	
	@PutMapping("/books/{id}/update")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		Long userid = (Long) session.getAttribute("user_id");
    	if (userid == null) {
    		return "redirect:/";
    	}
    	
		if(result.hasErrors()) {
		
//			model.addAttribute("book", bookServ.getBookById(id));
			return "EditBook.jsp";
		} else {
			Book bookFromDB = bookServ.getBookById(id);
			
			bookFromDB.setTitle(book.getTitle());
			bookFromDB.setAuthor(book.getAuthor());
			bookFromDB.setThoughts(book.getThoughts());
			
			bookServ.updateBook(book);
			return "redirect:/home";
		}
	}
	
    @DeleteMapping("/books/{id}/delete")
    public String destroy(@PathVariable("id") Long id, HttpSession session) {
    	Long userid = (Long) session.getAttribute("user_id");
    	if (userid == null) {
    		return "redirect:/";
    	}
        bookServ.delete(id);
        return "redirect:/home";
    }
    
	
	@PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		Long userid = (Long) session.getAttribute("user_id");
    	if (userid == null) {
    		return "redirect:/";
    	}
    	if (result.hasErrors()) {
    		
    		return "add.jsp";
    	} else {
    		bookServ.saveBook(book);
    		
    		return "redirect:/home";
    	}
    	
	}

	
}
