package io.javabrains.ratingsdataservice.models;

public class Rating {
    private String movieId;
    private int ratingId;

    public Rating(String movieId, int ratingId) {
        this.movieId = movieId;
        this.ratingId = ratingId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }
}
