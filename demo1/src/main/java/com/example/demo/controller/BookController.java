package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class BookController {
    @GetMapping(value = "/allBooks")
    public List<String> getAllBooks(BookRepository repository){
        List<String> allBooks = new ArrayList<>();
        repository.findAll().forEach(book -> {
            allBooks.add(book.toString());
        });
        return allBooks;
    }
}
