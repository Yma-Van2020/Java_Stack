package com.katelyn.authentication.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.katelyn.authentication.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();

}
