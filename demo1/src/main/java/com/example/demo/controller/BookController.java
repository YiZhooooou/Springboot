package com.example.demo.controller;

import com.example.demo.model.Book;
import javax.validation.Valid;
import com.example.demo.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/books/save/{id}")
    public Book updateBook(@RequestBody Book book,
                           @PathVariable("id") Integer bookId) {
        return bookService.updateBook(book, bookId);
    }

    @DeleteMapping("/books/delete/{id}")
    public String deleteBookById(@PathVariable("id") Integer bookId) {
        bookService.deleteBookById(bookId);
        return "Deleted Successfully";
    }

    // Demo
    @PostMapping("/books/saveDemo")
    public ResponseEntity<?> saveBookDemo(){
        Book res = bookService.saveBook(new Book(2005, "Computer Networks"));
        if (res != null)
            return new ResponseEntity<>(res, HttpStatus.OK);
        else
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/books/getDemoById")
    public ResponseEntity<?> getBookDemoById(){
        Book res = bookService.findById(2001);
        if (res != null)
            return new ResponseEntity<>(res, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("books/getDemoByName")
    public ResponseEntity<?> getBookDemoByName(){
        List<Book> res = bookService.findByName("Computer Networks");
        if (!res.isEmpty())
            return new ResponseEntity<>(res, HttpStatus.OK);
        else
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @GetMapping("books/getNoBooks")
    public ResponseEntity<?> getNoBooks(){
        List<Book> res = bookService.findByName("DOESNOTEXIST");
        if (!res.isEmpty())
            return new ResponseEntity<>(res, HttpStatus.OK);
        else
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
