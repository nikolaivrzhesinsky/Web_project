package com.example.bookmarketrest.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="author")
public class AuthorModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NonNull
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "zipcode_id")
    private ZipcodeModel zipcodeModel;

    @ManyToMany(mappedBy = "authorsModelList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookModel> bookModelList= new ArrayList<>();

    public AuthorModel(int id, String name, ZipcodeModel zipcodeModel, List<BookModel> bookModelList) {
        this.id = id;
        this.name = name;
        this.zipcodeModel = zipcodeModel;
        this.bookModelList = bookModelList;
    }

    public void removeBook(BookModel bookModel){
        bookModelList.remove(bookModel);
    }

    public void addBook(BookModel bookModel){
        bookModelList.add(bookModel);
    }
}


















