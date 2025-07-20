package com.solveva.spdjpa_intro;

import com.solveva.spdjpa_intro.domain.Book;
import com.solveva.spdjpa_intro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.solveva.spdjpa_intro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    void testJpaTestSlice() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);

        bookRepository.save(new Book("123", "My book", "Me", null));

        long countAfter = bookRepository.count();

        assertThat(count).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSliceTransaction() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(3);
    }
}
