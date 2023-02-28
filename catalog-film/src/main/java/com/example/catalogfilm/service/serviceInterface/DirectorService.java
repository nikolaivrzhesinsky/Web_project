package com.example.catalogfilm.service.serviceInterface;

import com.example.catalogfilm.model.Director;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.UUID;

public interface DirectorService {

    Director getDirector(UUID directorID) throws ChangeSetPersister.NotFoundException;

    Director saveDirector(Director director);
}
