package com.solveva.spdjpa_intro.repositories;

import com.solveva.spdjpa_intro.domain.BookUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}
