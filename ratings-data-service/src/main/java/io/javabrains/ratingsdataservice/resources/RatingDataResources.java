package io.javabrains.ratingsdataservice.resources;

import io.javabrains.ratingsdataservice.models.Rating;
import io.javabrains.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResources {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }
    @RequestMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
         List<Rating> ratings =  Arrays.asList(
                new Rating("a", 4),
                new Rating("b", 3)
        );
         UserRating userRating = new UserRating();
         userRating.setRatingList(ratings);
         return  userRating;
    }
}
