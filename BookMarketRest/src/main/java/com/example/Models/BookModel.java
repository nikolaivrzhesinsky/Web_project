package com.example.Models;

import jdk.jfr.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="book")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<AuthorModel> authorsModelList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryModel category;

    public BookModel(String name, List<AuthorModel> authors, CategoryModel category) {
        this.name = name;
        this.authorsModelList = authors;
        this.category = category;
    }

    public void addAuthor(AuthorModel author) {
        authorsModelList.add(author);
    }

    public void removeAuthor(AuthorModel author) {
        authorsModelList.remove(author);
    }

}
