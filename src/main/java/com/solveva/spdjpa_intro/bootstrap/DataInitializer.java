package com.solveva.spdjpa_intro.bootstrap;

import com.solveva.spdjpa_intro.domain.AuthorUuid;
import com.solveva.spdjpa_intro.domain.Book;
import com.solveva.spdjpa_intro.domain.BookUuid;
import com.solveva.spdjpa_intro.repositories.AuthorUUIDRepository;
import com.solveva.spdjpa_intro.repositories.BookRepository;
import com.solveva.spdjpa_intro.repositories.BookUuidRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final BookUuidRepository bookUuidRepository;
    private final AuthorUUIDRepository authorUUIDRepository;

    public DataInitializer(BookRepository bookRepository,
                           BookUuidRepository bookUuidRepository,
                           AuthorUUIDRepository authorUUIDRepository) {
        this.bookRepository = bookRepository;
        this.bookUuidRepository = bookUuidRepository;
        this.authorUUIDRepository = authorUUIDRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        Book book = new Book("DDD", "123", "John", null);

        bookRepository.save(book);

        Book bookSIA = new Book("SIA", "123", "Wick", null);

        bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(existingBook ->
                {
                    System.out.println("Book Id " + existingBook.getId());
                    System.out.println("Book title " + existingBook.getTitle());
                }
        );

        BookUuid bookUuid = new BookUuid();
        bookUuid.setTitle(" All about UUID");
        BookUuid savedBook = bookUuidRepository.save(bookUuid);
        System.out.println("Saved book uuid: " + savedBook.getId());

        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("Joe");
        authorUuid.setLastName("Buck");
        AuthorUuid savedAuthor = authorUUIDRepository.save(authorUuid);
        System.out.println("Saved Author UUID: " + savedAuthor.getId() );
    }
}
