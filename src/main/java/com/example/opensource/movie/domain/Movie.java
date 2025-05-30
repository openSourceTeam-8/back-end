package com.example.opensource.movie.domain;

import com.example.opensource.movie.domain.constant.MovieRating;
import com.example.opensource.review.domain.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "release_year", nullable = false)
    private LocalDate releaseYear;

    private String showtime;

    @Column(nullable = false, length = 50)
    private String title;

    private String genre;

    private String nation;

    @Column(length = 100)
    private String cast;

    @Column(length = 20)
    private String director;

    //@Enumerated(EnumType.STRING)
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "movie_rating", nullable = false)
    private MovieRating movieRating;

    // Relations
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieThumbnail> thumbnails;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

}
