package com.filmes.CineCritica.client;

import java.util.List;

public class MovieSearchResponse {
    private List<MovieResponseDto> results;

    public List<MovieResponseDto> getResults() {
        return results;
    }

    public void setResults(List<MovieResponseDto> results) {
        this.results = results;
    }
}
