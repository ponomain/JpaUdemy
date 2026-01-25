package com.solveva.spdjpa_intro;

import com.solveva.spdjpa_intro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpdjpaIntroApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void testBookRepo() {
		long count = bookRepository.count();

		assertThat(count).isGreaterThan(0);
	}
	@Test
	void contextLoads() {
	}

}
