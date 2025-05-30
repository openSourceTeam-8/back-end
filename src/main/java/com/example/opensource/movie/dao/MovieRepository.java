package com.example.opensource.movie.dao;

import com.example.opensource.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenre(String genre);

    List<Movie> findByNation(String country);


}
