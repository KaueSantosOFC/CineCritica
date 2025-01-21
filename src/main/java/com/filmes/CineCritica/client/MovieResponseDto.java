package com.filmes.CineCritica.client;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieResponseDto {

    @JsonProperty("title")
    private String title;
    private String overview;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("vote_average")
    private String voteAverage;
    @JsonProperty("id")
    private Long idMovieApi;

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

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Long getidMovieApi() {
        return idMovieApi;
    }

    public void setidMovieApi(Long idOut) {
        this.idMovieApi = idOut;
    }
}
