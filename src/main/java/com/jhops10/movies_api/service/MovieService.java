package com.jhops10.movies_api.service;

import com.jhops10.movies_api.entity.Movie;
import com.jhops10.movies_api.exceptions.NotFoundException;
import com.jhops10.movies_api.repository.MovieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        Sort sort = Sort.by(Sort.Order.desc("rating"), Sort.Order.asc("title"));
        return movieRepository.findAll(sort);
    }

    public List<Movie> getMoviesByTitle(String title) {
        List<Movie> movies = movieRepository.findByTitleContainingIgnoreCase(title);

        if (movies.isEmpty()) {
            throw new NotFoundException("No result found with that title ");
        }

        return movies;
    }

    public List<Movie> getMoviesByDescription(String description) {
        List<Movie> movies = movieRepository.findByDescriptionContainingIgnoreCase(description);

        if (movies.isEmpty()) {
            throw new NotFoundException("No movies found with that description");
        }

        return movies;
    }

}
