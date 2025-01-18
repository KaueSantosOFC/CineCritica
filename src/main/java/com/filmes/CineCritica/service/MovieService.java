package com.filmes.CineCritica.service;

import com.filmes.CineCritica.client.MovieApiClient;
import com.filmes.CineCritica.client.MovieResponseDto;
import com.filmes.CineCritica.client.MovieSearchResponse;
import com.filmes.CineCritica.entity.Movie;
import com.filmes.CineCritica.repository.MovieRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        System.out.println("ID recebido: " + idExterno);

        Optional<Movie> existingMovie = movieRepository.findByIdMovieApi(idExterno);
        if (existingMovie.isPresent()){
            return existingMovie.get();
        }
            // Busca os detalhes do filme
            MovieResponseDto responseDto = movieApiClient.getMovieDetails(idExterno,apiKey,"pt-BR");
            System.out.println("Response DTO: " + responseDto);

            // Converte para a entidade Movie
            Movie movieResponse = convertToEntity(responseDto);
            System.out.println("Converted Movie Entity: " + movieResponse);

            // Salva no repositório
            Movie movieSaved = movieRepository.save(movieResponse);
            System.out.println("Saved Movie: " + movieSaved);

            return movieSaved;

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
