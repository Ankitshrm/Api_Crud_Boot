package com.springboot.api_crud.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.springboot.api_crud.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public List<Book> findById(int id);
}
