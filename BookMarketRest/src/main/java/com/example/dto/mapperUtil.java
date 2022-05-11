package com.example.dto;

import com.example.Models.AuthorModel;
import com.example.Models.BookModel;
import com.example.Models.CategoryModel;
import com.example.dto.responseDto.AuthorResponseDto;
import com.example.dto.responseDto.BookResponseDto;
import com.example.dto.responseDto.CategoryResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class mapperUtil {
    public static BookResponseDto bookToBookResponseDto(BookModel bookModel){

        BookResponseDto bookResponseDto= new BookResponseDto();
        bookResponseDto.setId(bookModel.getId());
        bookResponseDto.setName(bookModel.getName());
        bookResponseDto.setCategoryName(bookModel.getCategory().getName());

        List<String> names= new ArrayList<>();
        List<AuthorModel> authorModelList= bookModel.getAuthorsModelList();

        for (AuthorModel author : authorModelList) {
            names.add(author.getName());
        }
        bookResponseDto.setAuthorNames(names);

        return bookResponseDto;
    }

    public static List<BookResponseDto> bookResponseDtoList(Iterable<BookModel> bookModelList){
        List<BookResponseDto> bookResponseDtoArrayList= new ArrayList<>();
        for (BookModel book : bookModelList) {
            bookResponseDtoArrayList.add(bookToBookResponseDto(book));
        }

        return bookResponseDtoArrayList;
    }

    public static AuthorResponseDto authorToAuthorResponseDto(AuthorModel author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setName(author.getName());

        List<String> names = new ArrayList<>();
        List<BookModel> books = author.getBookModelList();
        for (BookModel book: books) {
            names.add(book.getName());
        }
        authorResponseDto.setBookNames(names);

        return authorResponseDto;
    }

    public static List<AuthorResponseDto> authorResponseDtoList(Iterable<AuthorModel> authors){
        List<AuthorResponseDto> authorResponseDtoArrayList = new ArrayList<>();
        for (AuthorModel author: authors) {
            authorResponseDtoArrayList.add(authorToAuthorResponseDto(author));
        }
        return authorResponseDtoArrayList;
    }

    public static CategoryResponseDto categoryToCategoryResponseDto(CategoryModel category) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());
        List<String> names = new ArrayList<>();
        List<BookModel> books = category.getBooks();
        for (BookModel book : books) {
            names.add(book.getName());
        }
        categoryResponseDto.setBookNames(names);
        return categoryResponseDto;
    }

    public static List<CategoryResponseDto> categoriesToCategoryResponseDtoList(List<CategoryModel> categories) {
        List<CategoryResponseDto> categoryResponseDtoArrayList = new ArrayList<>();
        for (CategoryModel category: categories) {
            categoryResponseDtoArrayList.add(categoryToCategoryResponseDto(category));
        }
        return categoryResponseDtoArrayList;
    }
}
