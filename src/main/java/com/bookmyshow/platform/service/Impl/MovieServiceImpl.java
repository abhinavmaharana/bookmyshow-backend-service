package com.bookmyshow.platform.service.Impl;

import com.bookmyshow.platform.dto.MovieDTO;
import com.bookmyshow.platform.exception.ResourceNotFoundException;
import com.bookmyshow.platform.mapper.MovieMapper;
import com.bookmyshow.platform.model.Movie;
import com.bookmyshow.platform.repository.MovieRepository;
import com.bookmyshow.platform.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        Movie movie = MovieMapper.mapToMovies(movieDTO);
        Movie savedMovies = movieRepository.save(movie);

        return MovieMapper.mapToMovieDto(savedMovies);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map((movie) -> MovieMapper.mapToMovieDto(movie))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieById(String movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie does not exists with the given id : " + movieId));

        return MovieMapper.mapToMovieDto(movie);
    }

    @Override
    public MovieDTO updateMovie(String movieId, MovieDTO updatedMovie) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new ResourceNotFoundException("Movie does not exists with the given id : " + movieId)
        );

        // Update Operation
        movie.setId(updatedMovie.getId());
        movie.setTitle(updatedMovie.getTitle());
        movie.setDescription(updatedMovie.getDescription());
        movie.setCertification(updatedMovie.getCertification());
        movie.setCast(updatedMovie.getCast());
        movie.setCrew(updatedMovie.getCast());
        movie.setReviews(updatedMovie.getReviews());
        movie.setDurationInMinutes(updatedMovie.getDurationInMinutes());
        movie.setLanguage(updatedMovie.getLanguage());
        movie.setReleaseDate(updatedMovie.getReleaseDate());
        movie.setCountry(updatedMovie.getCountry());
        movie.setGenre(updatedMovie.getGenre());

        Movie updatedMovieObj = movieRepository.save(movie);

        return MovieMapper.mapToMovieDto(updatedMovieObj);
    }

    @Override
    public void deleteMovie(String movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new ResourceNotFoundException("Movie does not exists with the given id : " + movieId)
        );

        movieRepository.deleteById(movieId);
    }
}
