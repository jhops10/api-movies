package com.jhops10.movies_api.repository;

import com.jhops10.movies_api.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleContainingIgnoreCase(String title);
    List<Movie> findByRating(Integer rating);
    List<Movie> findByReleaseYear(Integer releaseYear);
    List<Movie> findByDescriptionContainingIgnoreCase(String description);

}
