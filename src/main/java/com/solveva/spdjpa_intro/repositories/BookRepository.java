package com.solveva.spdjpa_intro.repositories;

import com.solveva.spdjpa_intro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
