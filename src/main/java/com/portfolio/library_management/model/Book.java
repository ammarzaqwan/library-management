package com.portfolio.library_management.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "books", uniqueConstraints = {
@UniqueConstraint(columnNames = "isbn")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book extends BaseModel {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true)
    private String isbn;

    private String genre;

    private int publishedYear;

    private String description;

    // Enum for book availability status
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus status;

    // Number of copies of this book available in the library
    @Column(nullable = false)
    private int count;

    // Number of copies currently borrowed (to check availability)
    @Column(nullable = false)
    private int borrowedCount;

}
