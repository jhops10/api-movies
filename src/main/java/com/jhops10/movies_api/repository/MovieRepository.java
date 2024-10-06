package com.jhops10.movies_api.repository;

import com.jhops10.movies_api.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {
}
