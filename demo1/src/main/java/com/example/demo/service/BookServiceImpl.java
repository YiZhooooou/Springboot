package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchBookList() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book, Integer bookId) {
        Book depDB = bookRepository.findById(bookId).get();

        if (Objects.nonNull(book.getBookName())
                && !"".equalsIgnoreCase(book.getBookName())) {
            depDB.setBookName(book.getBookName());
        }

        return bookRepository.save(depDB);
    }

    @Override
    public void deleteBookById(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
