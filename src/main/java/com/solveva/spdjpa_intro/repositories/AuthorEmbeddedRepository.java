package com.solveva.spdjpa_intro.repositories;

import com.solveva.spdjpa_intro.domain.composite.AuthorEmbedded;
import com.solveva.spdjpa_intro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
