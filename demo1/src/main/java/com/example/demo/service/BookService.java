package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {
    // save operation
    Book saveBook(Book book);

    // read operation
    List<Book> fetchBookList();

    // update operation
    Book updateBook(Book book, Integer bookId);

    // delete operation
    void deleteBookById(Integer bookId);
}
