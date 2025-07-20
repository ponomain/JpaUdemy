package com.solveva.spdjpa_intro.bootstrap;

import com.solveva.spdjpa_intro.domain.Author;
import com.solveva.spdjpa_intro.domain.Book;
import com.solveva.spdjpa_intro.repositories.AuthorRepository;
import com.solveva.spdjpa_intro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default", "test"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        Book book = new Book("DDD", "123", "John", null);

        bookRepository.save(book);

        Book bookSIA = new Book("SIA", "123", "Wick", null);

        bookRepository.save(bookSIA);

        Author author = new Author("Nick", "Pick");
        authorRepository.save(author);


        bookRepository.findAll().forEach(existingBook ->
                {
                    System.out.println("Book Id" + existingBook.getId());
                    System.out.println("Book title" + existingBook.getTitle());
                }
        );

        authorRepository.findAll().forEach(existingAuthor ->
        {
            System.out.println("Author id" + existingAuthor.getId());
            System.out.println("Author name" + existingAuthor.getFirstName() + " " + existingAuthor.getLastName());
        });
    }
}
