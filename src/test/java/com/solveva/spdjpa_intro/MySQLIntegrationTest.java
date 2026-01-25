package com.solveva.spdjpa_intro;

import com.solveva.spdjpa_intro.domain.*;
import com.solveva.spdjpa_intro.domain.composite.AuthorComposite;
import com.solveva.spdjpa_intro.domain.composite.AuthorEmbedded;
import com.solveva.spdjpa_intro.domain.composite.NameId;
import com.solveva.spdjpa_intro.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.solveva.spdjpa_intro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookUuidRepository bookUuidRepository;
    @Autowired
    AuthorUUIDRepository authorUUIDRepository;
    @Autowired
    BookNaturalRepository bookNaturalRepository;
    @Autowired
    AuthorCompositeRepository authorCompositeRepository;
    @Autowired
    AuthorEmbeddedRepository authorEmbeddedRepository;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
        bookUuidRepository.deleteAll();
        authorUUIDRepository.deleteAll();
        bookNaturalRepository.deleteAll();
        authorCompositeRepository.deleteAll();
        authorEmbeddedRepository.deleteAll();
    }

    @Test
    void authorEmbeddedTest() {
        final var nameId = new NameId();
        final var authorEmbedded = new AuthorEmbedded(nameId);

        authorEmbeddedRepository.save(authorEmbedded);

        final var fetched  = authorEmbeddedRepository.findById(nameId);
        assertThat(fetched).isNotEmpty();
    }

    @Test
    void authorCompositeTest() {
        final var nameId = new NameId("John", "Wick");
        final var authorComposite = new AuthorComposite();
        authorComposite.setFirstName(nameId.getFirstName());
        authorComposite.setLastName(nameId.getLastName());
        authorComposite.setCountry("Nigeria");

        authorCompositeRepository.save(authorComposite);

        final var fetched = authorCompositeRepository.findById(nameId);
        assertThat(fetched).isNotEmpty();
    }

    @Test
    void bookNaturalTest() {
        BookNatural bookNatural = new BookNatural();
        bookNatural.setTitle("New Title");
        BookNatural saved = bookNaturalRepository.save(bookNatural);

        final var fetched = bookNaturalRepository.findById(saved.getTitle());
        assertThat(fetched).isNotEmpty();
    }

    @Test
    void testAuthorUUID() {
        var newEntity = new AuthorUuid();
        newEntity.setFirstName("Mark");
        newEntity.setLastName("Twen");

        final var savedEntity = authorUUIDRepository.save(newEntity);

        assertThat(authorUUIDRepository.count()).isEqualTo(1);
        assertThat(authorUUIDRepository.findById(savedEntity.getId())).isNotEmpty();
    }

    @Test
    void testBookUUID() {
        var newEntity = new BookUuid();
        newEntity.setTitle("New titile");
        newEntity.setIsbn("New isbn");
        newEntity.setPublisher("New publisher");

        final var savedEntity = bookUuidRepository.save(newEntity);

        assertThat(bookUuidRepository.count()).isEqualTo(1);
        assertThat(bookUuidRepository.findById(savedEntity.getId())).isNotEmpty();
    }
}
