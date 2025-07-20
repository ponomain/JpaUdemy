package com.solveva.spdjpa_intro.repositories;

import com.solveva.spdjpa_intro.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
