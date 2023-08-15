package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {
    private final BookService bookService;

    public BookStoreApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    CommandLineRunner getCommandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setAuthor("Shevchenko");
            book.setTitle("Catherine");
            book.setDescription("Great book");
            book.setCoverImage("image");
            book.setPrice(BigDecimal.valueOf(100));
            book.setIsbn("aos12301");
            bookService.save(book);
        };
    }
}
