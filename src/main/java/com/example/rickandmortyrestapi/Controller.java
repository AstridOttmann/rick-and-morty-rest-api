package com.example.rickandmortyrestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class Controller {
    private final RickAndMortyService service;

    public Controller(RickAndMortyService service) {
        this.service = service;
    }

    @GetMapping("character")
    List<RickAndMortyCharacter> getRickAndMortyCharacter() {
        return service.getAllRickAndMortyCharacters();
    }

}
