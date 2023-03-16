package com.example.rickandmortyrestapi;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RickAndMortyService {
    private final WebClient webClient = WebClient.create("https://rickandmortyapi.com/api");

    List<RickAndMortyCharacter> getAllRickAndMortyCharacters() {

        ResponseEntity<List<RickAndMortyCharacter>> responseEntity = webClient
                .get()
                .uri("/character")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<RickAndMortyCharacter>>() {
                })
                .block();
        return Objects.requireNonNull(responseEntity).getBody();
    }

}
