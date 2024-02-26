package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book saveBook(Book book);

    List<Book> fetchBookList();

    Book findById(Integer Id);

    Book updateBook(Book book, Integer bookId);

    void deleteBookById(Integer bookId);

    List<Book> findByName(String name);
}
