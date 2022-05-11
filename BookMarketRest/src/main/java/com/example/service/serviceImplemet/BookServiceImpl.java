package com.example.service.serviceImplemet;

import com.example.Models.AuthorModel;
import com.example.Models.BookModel;
import com.example.Models.CategoryModel;
import com.example.dto.mapperUtil;
import com.example.dto.requestDto.BookRequestDto;
import com.example.dto.responseDto.BookResponseDto;
import com.example.repository.BookRepository;
import com.example.service.serviceInerface.AuthorService;
import com.example.service.serviceInerface.BookService;
import com.example.service.serviceInerface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @Transactional
    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        BookModel bookModel=new BookModel();
        bookModel.setName(bookRequestDto.getName());

        if(bookRequestDto.getAuthorIds().isEmpty()){
            throw  new IllegalArgumentException("Have to be at least one author");
        }
        else{
            List<AuthorModel>authorModels= new ArrayList<>();
            for (int authorId : bookRequestDto.getAuthorIds()) {
                authorModels.add(authorService.getAuthor(authorId));
            }
            bookModel.setAuthorsModelList(authorModels);
        }

        if(bookRequestDto.getCategoryId()==null){
            throw new IllegalArgumentException("have to be at least one category");
        }
        else {
            bookModel.setCategory(categoryService.getCategory(bookRequestDto.getCategoryId()));
        }
        bookRepository.save(bookModel);
        return mapperUtil.bookToBookResponseDto(bookModel);
    }

    @Override
    public BookResponseDto getBookById(int bookId) {
        BookModel bookModel=getBook(bookId);
        return mapperUtil.bookToBookResponseDto(bookModel);
    }

    @Override
    public BookModel getBook(int bookId) {
        BookModel bookModel= bookRepository.findById(bookId).orElseThrow(()->
                new IllegalArgumentException("The is no book with such id"));

        return bookModel;
    }

    @Override
    public List<BookResponseDto> getBooks() {
        Iterable<BookModel> bookModels=bookRepository.findAll();
        return mapperUtil.bookResponseDtoList(bookModels);
    }

    @Transactional
    @Override
    public BookResponseDto deleteBook(int bookId) {
        BookModel bookModel= getBook(bookId);
        bookRepository.delete(bookModel);
        return mapperUtil.bookToBookResponseDto(bookModel);
    }

    @Transactional
    @Override
    public BookResponseDto editBook(int bookId, BookRequestDto bookRequestDto) {
        BookModel bookModel=getBook(bookId);
        bookModel.setName(bookRequestDto.getName());
        if(!bookRequestDto.getAuthorIds().isEmpty()){
            List<AuthorModel> authors = new ArrayList<>();
            for (int authorId: bookRequestDto.getAuthorIds()) {
                AuthorModel author = authorService.getAuthor(authorId);
                authors.add(author);
            }
            bookModel.setAuthorsModelList(authors);
        }
        if (bookRequestDto.getCategoryId() != null) {
            CategoryModel category = categoryService.getCategory(bookRequestDto.getCategoryId());
            bookModel.setCategory(category);
        }
        return mapperUtil.bookToBookResponseDto(bookModel);
    }

    @Transactional
    @Override
    public BookResponseDto addAuthorToBook(int bookId, int authorId) {
        BookModel book = getBook(bookId);
        AuthorModel author = authorService.getAuthor(authorId);
        if (author.getBookModelList().contains(book)) {
            throw new IllegalArgumentException("this author is already assigned to this book");
        }
        book.addAuthor(author);
        author.addBook(book);
        return mapperUtil.bookToBookResponseDto(book);
    }

    @Transactional
    @Override
    public BookResponseDto deleteAuthorFromBook(int bookId, int authorId) {
        BookModel book = getBook(bookId);
        AuthorModel author = authorService.getAuthor(authorId);
        if (!(author.getBookModelList().contains(book))){
            throw new IllegalArgumentException("book does not have this author");
        }
        author.removeBook(book);
        book.removeAuthor(author);
        return mapperUtil.bookToBookResponseDto(book);
    }

    @Transactional
    @Override
    public BookResponseDto addCategoryToBook(int bookId, int categoryId) {
        BookModel book = getBook(bookId);
        CategoryModel category = categoryService.getCategory(categoryId);
        if (Objects.nonNull(book.getCategory())){
            throw new IllegalArgumentException("book already has a catogory");
        }
        book.setCategory(category);
        category.addBook(book);
        return mapperUtil.bookToBookResponseDto(book);
    }

    @Override
    public BookResponseDto removeCategoryFromBook(int bookId, int categoryId) {
        BookModel book = getBook(bookId);
        CategoryModel category = categoryService.getCategory(categoryId);
        if (!(Objects.nonNull(book.getCategory()))){
            throw new IllegalArgumentException("book does not have a category to delete");
        }
        book.setCategory(null);
        category.removeBook(book);
        return mapperUtil.bookToBookResponseDto(book);
    }
}
