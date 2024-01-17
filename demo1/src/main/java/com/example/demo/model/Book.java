package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer bookId;
    private String bookName;

    // Constructors, getters, and setters
    public Book() {

    }

    public Book(Integer id, String name) {
        this.bookId = id;
        this.bookName = name;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer id) {
        this.bookId = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String name) {
        this.bookName = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, name='%s']",
                bookId, bookName);
    }
}
