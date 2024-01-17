package com.example.demo.controller;

import com.example.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    Book findById(Integer bookId);
}
