package com.springboot.api_crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api_crud.dao.BookRepository;
import com.springboot.api_crud.entities.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		List<Book> allBook= (List<Book>)this.bookRepository.findAll();
		return allBook;
	}
	
	public Book getBookById(int id) {
		Book b =null;
		try {
		 b=(Book) this.bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		return b;
	}
	
	public Book addBook(Book book) {
		Book b=this.bookRepository.save(book);
		return b;
	}
	
	public void updateBook(Book book ,int id) {
		book.setId(id);
		this.bookRepository.save(book);
		
	}
	
	public void deleteBook(int id) {
		this.bookRepository.deleteById(id);
	}
}
