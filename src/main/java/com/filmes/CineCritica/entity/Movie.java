package com.filmes.CineCritica.entity;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 5000)
    private String overview;
    //https://image.tmdb.org/t/p/w500(PosterPath) para retornar as imagens e ter no front
    private String posterPath;
    private Double voteAverage;
    private Long idMovieApi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Long getIdMovieApi() {
        return idMovieApi;
    }

    public void setIdMovieApi(Long idMovieApi) {
        this.idMovieApi = idMovieApi;
    }
}
