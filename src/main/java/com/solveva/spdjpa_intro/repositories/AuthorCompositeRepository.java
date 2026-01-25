package com.solveva.spdjpa_intro.repositories;

import com.solveva.spdjpa_intro.domain.composite.AuthorComposite;
import com.solveva.spdjpa_intro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
