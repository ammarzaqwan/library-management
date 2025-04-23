package com.portfolio.library_management.dto.BookDTO;

import com.portfolio.library_management.model.Book.BookStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookReqDTO {

    private String title;
    private String author;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    private String genre;
    private int publishedYear;

    private String description;
    private BookStatus status;
    private String count;


}
