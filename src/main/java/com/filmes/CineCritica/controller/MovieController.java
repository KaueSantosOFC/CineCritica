package com.filmes.CineCritica.controller;

import com.filmes.CineCritica.dto.ReviewRequestDto;
import com.filmes.CineCritica.entity.Movie;
import com.filmes.CineCritica.repository.MovieRepository;
import com.filmes.CineCritica.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;

    //Retorna JSON
    @GetMapping("/api/{title}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.getMoviesByTitle(title);
        return ResponseEntity.ok(movies);
    }

    //Retorna JSON
    @GetMapping("/api/save/{idExterno}")
    public ResponseEntity<String> saveMovieById(@PathVariable Long idExterno) {
        boolean isNew = movieRepository.findByIdMovieApi(idExterno).isPresent();
        if (!isNew) {
            Movie movieSaved = movieService.saveMovieById(idExterno);
            return ResponseEntity.ok("Filme salvo com sucesso: " + movieSaved.getTitle());
        }
        else {
            Movie movieExists = movieRepository.findByIdMovieApi(idExterno).get();
            return ResponseEntity.ok("Filme já existente: " + movieExists.getTitle());
        }
    }

    @GetMapping("/api/listmovies")
    public List<Movie> findAllMovies() {
        return movieService.findAllMovies();
    }

    @PostMapping("/api/addReview")
    public ResponseEntity<String> addReview(@RequestBody ReviewRequestDto reviewRequest) {
        movieService.addReview(reviewRequest.getMovieId(), reviewRequest.getReview());
        return ResponseEntity.ok("Nota salva com sucesso!");
    }

    @DeleteMapping("/api/remove/{id}")
    public ResponseEntity<String> removeMovie(@PathVariable Long id) {
        movieService.removeMovieById(id);
        return ResponseEntity.ok("Filme removido com sucesso!");
    }

    // Renderiza o index.html
    @GetMapping
    public ModelAndView getMoviesByTitlePage(@RequestParam String title) {
        List<Movie> movies = movieService.getMoviesByTitle(title);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("movies", movies);
        return mv;
    }

    //Renderiza o mymovies.html
    @GetMapping("/meus-filmes")
    public ModelAndView myMoviesPage() {
        List <Movie> movies = movieService.findAllMovies();
        ModelAndView mv = new ModelAndView("mymovies");
        mv.addObject("movies", movies);
        return mv;
    }


}
