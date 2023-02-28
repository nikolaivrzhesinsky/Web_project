package com.example.catalogfilm.service.serviceInterface;

import com.example.catalogfilm.model.Film;

import java.util.UUID;

public interface FilmService {

    Film getFilm(UUID filmID);

    Film saveFilm(Film film);
}
