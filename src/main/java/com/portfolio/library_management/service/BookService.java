package com.portfolio.library_management.service;

import com.portfolio.library_management.dto.BookDTO.BookReqDTO;
import com.portfolio.library_management.dto.BookDTO.BookResDTO;
import com.portfolio.library_management.dto.MemberDto.MemberReqDTO;

public interface BookService {
    BookResDTO addBook(BookReqDTO dto);
}
