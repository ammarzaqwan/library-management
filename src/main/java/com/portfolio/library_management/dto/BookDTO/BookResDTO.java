package com.portfolio.library_management.dto.BookDTO;


import com.portfolio.library_management.model.Book.BookStatus;
import lombok.Data;

@Data
public class BookResDTO {


        private String title;
        private String author;
        private String isbn;
        private String genre;
        private int publishedYear;
        private String description;
        private BookStatus status;
        private String count;


    }
