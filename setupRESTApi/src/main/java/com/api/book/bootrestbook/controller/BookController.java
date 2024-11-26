package com.api.book.bootrestbook.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.service.BookService;
@RestController
public class BookController {
	@Autowired
	private BookService bookservice;	
//	@RequestMapping(value = "/book", method = RequestMethod.GET)
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookservice.GetAllBooks();
	}
	
	/*----------------------------------------------------------------------*/
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		
		return bookservice.getBookById(id);
	}
	
	/*----------------------------------------------------------------------*/
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b= this.bookservice.addBook(book);
		System.out.println(b);
		return b;
	}
	
	/*----------------------------------------------------------------------*/
	
	@DeleteMapping("/books/{bookId}")
	public  void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookservice.deletebooks( bookId);
		
	}
	
	
	/*----------------------------------------------------------------------*/
	
	// UPDATING BOOK BY ID
	@PutMapping("/books/{bookId}")
	public Book updateBooks(@RequestBody Book book,@PathVariable("bookId") int bid) {
		
		this.bookservice.updateBooks(book,bid);
		return book;
		
		
		
	}
	
	/*----------------------------------------------------------------------*/
	
	
	}
