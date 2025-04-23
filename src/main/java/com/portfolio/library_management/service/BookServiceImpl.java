package com.portfolio.library_management.service;

import com.portfolio.library_management.dto.BookDTO.BookReqDTO;
import com.portfolio.library_management.dto.BookDTO.BookResDTO;
import com.portfolio.library_management.exception.ApiException;
import com.portfolio.library_management.mapper.BookMapper;
import com.portfolio.library_management.model.Book.Book;
import com.portfolio.library_management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    @Override
    public BookResDTO addBook(BookReqDTO dto){
    if (repository.findByisbn(dto.getIsbn()).isPresent()){
        throw new ApiException("ISBN for this book exist", HttpStatus.BAD_REQUEST);

    }
        Book book=mapper.toEntity(dto);

    try{
        Book saved = repository.save(book);
        return mapper.toDto(saved);
    } catch(DataIntegrityViolationException e){

        throw new ApiException("Book details already exists", HttpStatus.BAD_REQUEST);

    }

    }

    @Override
    public List<BookResDTO> getAllBooks(){
        List<Book> book = repository.findAll();
        if (book.isEmpty()) {
            throw new ApiException("No book found", HttpStatus.NOT_FOUND);
        }
        return book.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
