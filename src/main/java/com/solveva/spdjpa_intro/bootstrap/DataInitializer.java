package com.solveva.spdjpa_intro.bootstrap;

import com.solveva.spdjpa_intro.domain.Book;
import com.solveva.spdjpa_intro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default", "test"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {this.bookRepository = bookRepository;}

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        Book book = new Book("DDD", "123", "John", null);

        bookRepository.save(book);

        Book bookSIA = new Book("SIA", "123", "Wick", null);

        bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(existingBook ->
                {
                    System.out.println("Book Id" + existingBook.getId());
                    System.out.println("Book title" + existingBook.getTitle());
                }
        );
    }
}
