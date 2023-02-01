package com.springboot.api_crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api_crud.entities.Book;
import com.springboot.api_crud.services.BookService;

@RestController
public class MainController {
	@Autowired
	private BookService bookServices;
	
	@GetMapping(value="/books")
	public ResponseEntity <List<Book>> getAllBooks(){
		List<Book> list =this.bookServices.getAllBooks();
		if(list.size()<0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		 return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping(value=	"/books/{id}")
	public Book getBookById(@PathVariable("id")int id) {
		return this.bookServices.getBookById( id);
	}
	
	@PostMapping(value="/books")
	public Book addingBook(@RequestBody Book b) {
		Book book = this.bookServices.addBook(b);
		return book;
	}
	
	@DeleteMapping("/books/{bid}")
	public void deleteBook(@PathVariable("bid") int b) {
		this.bookServices.deleteBook(b);
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
		this.bookServices.updateBook(book, bookId);
		return book;
	}
	

}
