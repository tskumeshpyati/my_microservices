package io.javabrains.moviecatalogservice.models;

import java.util.List;

public class UserRating {
    private List<Rating> ratingList;
    private String userId;

    public UserRating() {

    }
    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
