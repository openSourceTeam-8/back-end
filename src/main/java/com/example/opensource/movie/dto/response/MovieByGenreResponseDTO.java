package com.example.opensource.movie.dto.response;

import com.example.opensource.movie.domain.Movie;

public record MovieByGenreResponseDTO(
        String title,
        String genre,
        String director,
        String rating,
        int reviewCount,
        String thumbnailUrl
) {
    public static MovieByGenreResponseDTO from(Movie movie) {
        return new MovieByGenreResponseDTO(
                movie.getTitle(),
                movie.getGenre(),
                movie.getDirector(),
                movie.getMovieRating().getDisplayName(),
                movie.getReviews().size(),
                movie.getThumbnails().isEmpty() ? null : movie.getThumbnails().get(0).getUrl()
        );
    }
}
