package com.solveva.spdjpa_intro.repositories;

import com.solveva.spdjpa_intro.domain.AuthorUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorUUIDRepository extends JpaRepository<AuthorUuid, UUID> {
}
