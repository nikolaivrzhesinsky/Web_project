package com.example.catalogfilm.controller;

import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.service.serviceInterface.DirectorService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/director")
public class DirectController {

    private final DirectorService directorService;

    @PostMapping
    public ResponseEntity<?> addDirector(@RequestBody Director directorReq) {

        Director resultDirector = directorService.saveDirector(directorReq);
        return ResponseEntity.ok(resultDirector);
    }

    @SneakyThrows
    @GetMapping
    public ResponseEntity<?> getDirector(@RequestParam("directorId") UUID directorId) {

        Director director = directorService.getDirector(directorId);
        return ResponseEntity.ok(director);
    }


}
