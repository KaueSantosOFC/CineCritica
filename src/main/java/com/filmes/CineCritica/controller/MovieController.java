package com.filmes.CineCritica.controller;

import com.filmes.CineCritica.client.MovieResponseDto;
import com.filmes.CineCritica.entity.Movie;
import com.filmes.CineCritica.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/{title}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.getMoviesByTitle(title);
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/save/{idExterno}")
    public ResponseEntity<Movie> saveMovieByid(@PathVariable Long idExterno) {
        Movie movieSaved = movieService.saveMovieById(idExterno);
        return ResponseEntity.ok(movieSaved);
    }

//    @PostMapping
//    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
//        return ResponseEntity.ok(movieService.saveMovie(movie));
//    }
}
