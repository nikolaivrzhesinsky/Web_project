package com.example.bookmarketrest.service.serviceInerface;

import com.example.bookmarketrest.Models.BookModel;
import com.example.bookmarketrest.dto.requestDto.BookRequestDto;
import com.example.bookmarketrest.dto.responseDto.BookResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public BookResponseDto addBook(BookRequestDto bookRequestDto);
    public BookResponseDto getBookById(int bookId);
    public BookModel getBook(int bookId);
    public List<BookResponseDto> getBooks();
    public BookResponseDto deleteBook(int bookId);
    public BookResponseDto editBook(int bookId, BookRequestDto bookRequestDto);
    public BookResponseDto addAuthorToBook(int bookId, int authorId);
    public BookResponseDto deleteAuthorFromBook(int bookId, int authorId);
    public BookResponseDto addCategoryToBook(int bookId, int categoryId);
    public BookResponseDto removeCategoryFromBook(int bookId, int categoryId);
}
