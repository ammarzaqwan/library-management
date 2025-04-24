package com.portfolio.library_management.service;

import com.portfolio.library_management.dto.BookDTO.BookReqDTO;
import com.portfolio.library_management.dto.BookDTO.BookResDTO;
import com.portfolio.library_management.dto.MemberDto.MemberReqDTO;

import java.util.List;
import java.util.UUID;

public interface BookService {
    BookResDTO addBook(BookReqDTO dto);
    List<BookResDTO> getAllBooks();
    BookResDTO updBook(BookReqDTO dto, UUID id);
    BookResDTO getBooksById(UUID id);
    void deleteBooks(UUID id);
}
