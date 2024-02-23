package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findById(Integer id);
    List<Book> findByBookName(String name);
}
