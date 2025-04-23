package com.portfolio.library_management.model.Book;


public enum BookStatus {
    AVAILABLE,       // Book is available for borrowing
    BORROWED,        // Book is currently borrowed
    RESERVED,        // Book is reserved but not borrowed yet
    DAMAGED,         // Book is damaged and not available for borrowing
    RETURNED,
    LOANED,
    LOST             // Book is lost
}
