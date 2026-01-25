package com.solveva.spdjpa_intro.repositories;

import com.solveva.spdjpa_intro.domain.BookNatural;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookNaturalRepository extends JpaRepository<BookNatural, String> {
}
