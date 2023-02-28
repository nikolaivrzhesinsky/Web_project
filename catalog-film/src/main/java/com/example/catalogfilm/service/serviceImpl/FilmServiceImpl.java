package com.example.catalogfilm.service.serviceImpl;

import com.example.catalogfilm.model.Film;
import com.example.catalogfilm.repository.FilmReposytory;
import com.example.catalogfilm.service.serviceInterface.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmReposytory filmReposytory;

    @SneakyThrows(ChangeSetPersister.NotFoundException.class)
    @Override
    public Film getFilm(UUID filmID) {

        Optional<Film> filmOptional = filmReposytory.findById(filmID);
        return filmOptional.orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public Film saveFilm(Film film) {

        return filmReposytory.save(film);
    }
}
