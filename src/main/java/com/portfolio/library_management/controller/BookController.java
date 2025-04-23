package com.portfolio.library_management.controller;

import com.portfolio.library_management.dto.BookDTO.BookReqDTO;
import com.portfolio.library_management.dto.BookDTO.BookResDTO;
import com.portfolio.library_management.dto.MemberDto.MemberReqDTO;
import com.portfolio.library_management.service.BookService;
import com.portfolio.library_management.utils.ApiResponse;
import com.portfolio.library_management.utils.Record;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping("/api/public/books")
    public ResponseEntity<ApiResponse<BookResDTO>> addBook(@RequestBody BookReqDTO dto){
        BookResDTO book =service.addBook(dto);

        ApiResponse<BookResDTO> response = new ApiResponse<>(
                Record.CREATE.getMessage(),
                book,
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

}
