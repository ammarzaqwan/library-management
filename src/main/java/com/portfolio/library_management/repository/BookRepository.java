package com.portfolio.library_management.repository;


import com.portfolio.library_management.model.Book.Book;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Object> findByisbn(@NotBlank(message = "ISBN is required") String ISBN);

}