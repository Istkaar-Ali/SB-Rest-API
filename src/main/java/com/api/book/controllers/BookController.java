package com.api.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookServices;

@RestController
public class BookController {
	
	@Autowired	
	private BookServices bookServices; 

//	@GetMapping("/books")
//	public String getBooks() {
//		return "this is testing book first";
//	}
	
	
	// for single book
	
//	@GetMapping("/books")
//	public Book getBooks() {
//		Book book = new Book();
//		book.setId(1234);
//		book.setTitle("Complete java reference");
//		book.setAuthor("XYZ");
//		return book;
//	}
	
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		Book book = new Book();
		book.setId(1234);
		book.setTitle("Complete java reference");
		book.setAuthor("XYZ");
		return this.bookServices.getAllBooks();
	}
	
	

	// get single books handler.......
		
		@GetMapping("/books/{id}")
		public Book getBook(@PathVariable("id") int id)
		{
			return bookServices.getBookById(id);
		}
		
		
		
		
		
		//  new book handler.......
		
		@PostMapping("/books")
		public Book addBook(@RequestBody Book book) 
		{
		Book b=this.bookServices.addBook(book);
		return b;
		}
		
		
		
		// delete book handler
		@DeleteMapping("/books/{bookId}")
		public void deleteBook(@PathVariable("bookId") int bookId)
		{
			this.bookServices.deleteBook(bookId);
		}
		
		
		
		
		
		// update book handler
		@PutMapping("/books/{bookId}")
		public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId)
		{
			this.bookServices.updateBook(book, bookId);
			return book;
		}
	
	
	
	
	
	
}
