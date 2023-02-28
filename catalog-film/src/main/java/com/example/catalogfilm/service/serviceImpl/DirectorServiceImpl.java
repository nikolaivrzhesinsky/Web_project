package com.example.catalogfilm.service.serviceImpl;

import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.repository.DirectorReposytory;
import com.example.catalogfilm.service.serviceInterface.DirectorService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorReposytory directorReposytory;

    @SneakyThrows(ChangeSetPersister.NotFoundException.class)
    @Override
    public Director getDirector(UUID directorID) {

        Optional<Director> directorOptional = directorReposytory.findById(directorID);
        return directorOptional.orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public Director saveDirector(Director director) {

        return directorReposytory.save(director);
    }
}
