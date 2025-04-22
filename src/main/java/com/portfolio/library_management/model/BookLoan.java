package com.portfolio.library_management.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "book_loans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookLoan {

    @Id
    @GeneratedValue
    private UUID id;

    // Reference to the book being borrowed
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    // Reference to the member borrowing the book
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // The due date for this specific borrow
    @Column(nullable = false)
    private Instant dueDate;

    // The actual return date of the book (null if not returned)
    private Instant returnedDate;

    // Book loan status
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus loanStatus;  // Tracks whether the book is currently borrowed, returned, etc.

    @PrePersist
    public void prePersist() {
        if (this.loanStatus == null) {
            this.loanStatus = BookStatus.LOANED;  // Default to LOANED status when a book is borrowed
        }
    }

    // Method to mark the book as returned
    public void markAsReturned() {
        this.loanStatus = BookStatus.RETURNED;
        this.returnedDate = Instant.now();  // Set returned date to current time
    }
}
