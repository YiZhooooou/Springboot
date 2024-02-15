package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;


@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Demo1Application.class);

    public BookRepository repository;

    public Demo1Application(BookRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Book(1001, "Bauer"));
        repository.save(new Book(1002, "O'Brian"));
        repository.save(new Book(1003, "Bauer"));
        repository.save(new Book(1004, "Palmer"));
        repository.save(new Book(1005, "Dessler"));

        // fetch all books
        log.info("Books found with findAll():");
        log.info("-------------------------------");
        repository.findAll().forEach(book -> {
            log.info(book.toString());
        });
        log.info("");

        // fetch an individual book by ID
        Optional<Book> book1 = repository.findById(1001);
        log.info("Book found with findById(1001):");
        log.info("--------------------------------");
        log.info(book1.toString());
        log.info("");

        // fetch customers by last name
        log.info("Books found with findByName('Bauer'):");
        log.info("--------------------------------------------");
        repository.findByBookName("Bauer").forEach(bauer -> {
            log.info(bauer.toString());
        });
        log.info("");
    }
}
