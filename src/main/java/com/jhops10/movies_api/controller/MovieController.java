package com.jhops10.movies_api.controller;

import com.jhops10.movies_api.entity.Movie;
import com.jhops10.movies_api.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }



    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/find/by-title")
    public List<Movie> getMoviesByTitle(@RequestParam String title) {
        return movieService.getMoviesByTitle(title);
    }

    @GetMapping("find/by-description")
    public List<Movie> getMoviesByDescription(@RequestParam String description) {
        return movieService.getMoviesByDescription(description);
    }


}
