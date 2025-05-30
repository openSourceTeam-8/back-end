package com.example.opensource.review.repository;

import com.example.opensource.movie.domain.Movie;
import com.example.opensource.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findFirstByMovieOrderByCreatedAtDesc(Movie movie);

}
