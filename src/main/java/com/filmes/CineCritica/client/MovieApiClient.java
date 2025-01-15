package com.filmes.CineCritica.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "movieApiClient", url = "https://api.themoviedb.org/3")
public interface MovieApiClient {

    @GetMapping("/movie/{movieId}")
    MovieResponseDto getMovieDetails(
            @PathVariable("movieId") Long movieId,
            @RequestHeader("Authorization") String apiKey,
            @RequestParam("language") String language
            );

    @GetMapping("/search/movie")
    MovieSearchResponse searchMovie(
            @RequestParam("query") String title,
            @RequestParam("language") String language,
            @RequestHeader("Authorization") String apiKey
    );
}
