package com.bookmyshow.platform.mapper;


import com.bookmyshow.platform.dto.MovieDTO;
import com.bookmyshow.platform.model.Movie;

public class MovieMapper {

    public static MovieDTO mapToMovieDto(Movie movie) {
        return new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getDurationInMinutes(),
                movie.getLanguage(),
                movie.getReleaseDate(),
                movie.getCountry(),
                movie.getGenre()
        );
    }

    public static Movie mapToMovies(MovieDTO movieDTO) {
        return new Movie(
                movieDTO.getId(),
                movieDTO.getTitle(),
                movieDTO.getDescription(),
                movieDTO.getDurationInMinutes(),
                movieDTO.getLanguage(),
                movieDTO.getReleaseDate(),
                movieDTO.getCountry(),
                movieDTO.getGenre()
        );
    }
}
