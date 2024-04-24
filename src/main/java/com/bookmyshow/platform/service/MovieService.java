package com.bookmyshow.platform.service;

import com.bookmyshow.platform.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    MovieDTO createMovie(MovieDTO movieDTO);
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieById(String movieId);
    MovieDTO updateMovie(String movieId, MovieDTO movieDTO);
    void deleteMovie(String movieId);
}
