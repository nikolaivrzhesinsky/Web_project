package com.example.catalogfilm.controller;


import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.model.Film;
import com.example.catalogfilm.service.serviceInterface.DirectorService;
import com.example.catalogfilm.service.serviceInterface.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/film")
public class FilmController {

    private final FilmService filmService;

    @PostMapping
    public ResponseEntity<?> addFilm(@RequestBody Film filmReq) {

        Film resultFilm = filmService.saveFilm(filmReq);
        return ResponseEntity.ok(resultFilm);
    }

    @SneakyThrows
    @GetMapping
    public ResponseEntity<?> getFilm(@RequestParam("filmId") UUID filmId) {

        Film film = filmService.getFilm(filmId);
        return ResponseEntity.ok(film);
    }


}
