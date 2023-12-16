package com.api.book.services;
import com.api.book.entities.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class BookServices {

	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(12, "Java complete refernce!!", "XYZ"));
		list.add(new Book(12345, "Python complete refernce!!", "LMN"));
		list.add(new Book(1156, "PHP complete refernce!!", "ABC"));
	}

	// get all books........
	public List<Book> getAllBooks()
	{
		return list;
	}
	 
	
	// get single book..........
	
	public Book getBookById(int id)
	{
		Book book = null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	
	
	// adding or Create the book......
	public Book addBook(Book b) 
	{
		list.add(b);
		return b;
	}
	
	
	
	// delete book   // we are using lambda here multiple line

//	public void deleteBook(int bid) {
//		list=list.stream().filter(book->{
//			if(book.getId()!=bid) {
//				return true;
//			}else {
//				return false;
//			}
//		}).collect(Collectors.toList());
//	}
//	
	
	
	// we are use lambda here in single line but
	public void deleteBook(int bid) {
		list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
	}
	
	
	
	
	
	// update the book
	public void updateBook(Book book, int bookId) {
		list=list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
	
	

}
