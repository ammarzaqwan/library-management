package com.portfolio.library_management.dto.BookDTO;


import lombok.Data;

@Data
public class BookResDTO {


        private String title;
        private String author;
        private String isbn;
        private String genre;
        private int publishedYear;
        private String description;
        private String BookStatus;
        private String count;


    }
