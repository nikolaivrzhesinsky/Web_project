package com.example.bookmarketrest.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookModel> books = new ArrayList<>();

    public CategoryModel(String name, List<BookModel> books) {
        this.name = name;
        this.books = books;
    }

    public void addBook(BookModel book) {
        books.add(book);
    }

    public void removeBook(BookModel book) {
        books.remove(book);
    }
}
