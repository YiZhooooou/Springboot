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

    @PostMapping("/books")
    public Book saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/books")
    public List<Book> fetchBookList() {
        return bookService.fetchBookList();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book,
                           @PathVariable("id") Integer bookId) {
        return bookService.updateBook(book, bookId);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") Integer bookId) {
        bookService.deleteBookById(bookId);
        return "Deleted Successfully";
    }

    // Demo
    @PostMapping("/books/saveDemo")
    public Book saveBookDemo(){
        return bookService.saveBook(new Book(2001, "Computer Networks"));
    }

    @GetMapping("/books/getDemoById")
    public Book getBookDemoById(){
        return bookService.findById(2001);
    }

    @GetMapping("books/getDemoByName")
    public List<Book> getBookDemoByName(){
        return bookService.findByName("Computer Networks");
    }
}
