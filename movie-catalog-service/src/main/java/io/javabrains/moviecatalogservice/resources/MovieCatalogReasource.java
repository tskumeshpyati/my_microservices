package io.javabrains.moviecatalogservice.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;
import io.javabrains.moviecatalogservice.services.MovieInfo;
import io.javabrains.moviecatalogservice.services.RatingsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogReasource {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private RatingsInfo ratingsInfo;

    @Autowired
    private MovieInfo movieInfo;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = ratingsInfo.getUserRatings(userId);
        return userRating.getRatingList().stream().map(rating -> movieInfo.getCatalogItem(rating))
        .collect(Collectors.toList());
    }
}

  /*
            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8081/movies/"+rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
  */
