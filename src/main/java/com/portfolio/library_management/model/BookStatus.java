package com.portfolio.library_management.model;


public enum BookStatus {
    AVAILABLE,       // Book is available for borrowing
    BORROWED,        // Book is currently borrowed
    RESERVED,        // Book is reserved but not borrowed yet
    DAMAGED,         // Book is damaged and not available for borrowing
    LOST             // Book is lost
}
