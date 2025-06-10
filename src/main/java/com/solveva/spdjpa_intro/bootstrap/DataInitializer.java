package com.solveva.spdjpa_intro.bootstrap;

import com.solveva.spdjpa_intro.domain.Book;
import com.solveva.spdjpa_intro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {this.bookRepository = bookRepository;}

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book("DDD", "123", "John");

        System.out.println("Id:" + book.getId());

        Book savedBook = bookRepository.save(book);

        System.out.println("Id:" + savedBook.getId());

        Book bookSIA = new Book("SIA", "123", "Wick");

        System.out.println("Id:" + bookSIA.getId());

        Book savedBookSIA = bookRepository.save(bookSIA);

        System.out.println("Id:" + savedBookSIA.getId());

        bookRepository.findAll().forEach(existingBook ->
                {
                    System.out.println("Book Id" + existingBook.getId());
                    System.out.println("Book title" + existingBook.getTitle());
                }
        );
    }
}
