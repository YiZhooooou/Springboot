package com.example.demo.controller;

import com.example.demo.model.Book;
import javax.validation.Valid;
import com.example.demo.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class BookController {
    @Autowired
    private BookService bookService;

    // Save operation
    @PostMapping("/books")
    public Book saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // Read operation
    @GetMapping("/books")
    public List<Book> fetchBookList() {
        return bookService.fetchBookList();
    }

    // Update operation
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book,
                           @PathVariable("id") Integer bookId) {
        return bookService.updateBook(book, bookId);
    }

    // Delete operation
    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") Integer bookId) {
        bookService.deleteBookById(bookId);
        return "Deleted Successfully";
    }
}
