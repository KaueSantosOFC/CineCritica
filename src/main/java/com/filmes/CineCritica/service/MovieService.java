package com.filmes.CineCritica.service;

import com.filmes.CineCritica.client.MovieApiClient;
import com.filmes.CineCritica.client.MovieResponseDto;
import com.filmes.CineCritica.client.MovieSearchResponse;
import com.filmes.CineCritica.entity.Movie;
import com.filmes.CineCritica.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieApiClient movieApiClient;
    @Autowired
    private MovieRepository movieRepository;
    @Value("${tmdb.api-key}")
    private String apiKey;

    public List<Movie> getMoviesByTitle(String title){
        MovieSearchResponse response = movieApiClient.searchMovie(title, "pt-BR", apiKey);
        return response.getResults()
                .stream()
                .map(this::convertToEntity) // Chama o método para conversão
                .collect(Collectors.toList());
    }

    public Movie saveMovieById(Long idExterno){
        MovieResponseDto responseDto = movieApiClient.getMovieDetails(idExterno,apiKey,"pt-BR");
        Movie movieResponse = convertToEntity(responseDto);
       return movieRepository.save(movieResponse);
    }

    private Movie convertToEntity (MovieResponseDto dto){
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setOverview(dto.getOverview());
        movie.setPosterPath(dto.getPosterPath());
        movie.setVoteAverage(dto.getVoteAverage());
        movie.setIdMovieApi(dto.getidMovieApi());
        return movie;
    }
}
