package com.filmes.CineCritica.dto;

public class ReviewRequestDto {
    private Long movieId;
    private int review;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }
}
