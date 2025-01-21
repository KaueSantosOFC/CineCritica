package com.filmes.CineCritica.dto;

public class ReviewRequestDto {
    private Long movieId;
    private String review;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
