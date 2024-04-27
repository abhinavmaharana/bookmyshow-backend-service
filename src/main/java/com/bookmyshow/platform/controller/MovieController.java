package com.bookmyshow.platform.controller;

import com.bookmyshow.platform.dto.MovieDTO;
import com.bookmyshow.platform.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private MovieService movieService;

    // Add Movies API
    @PostMapping("/admin/createMovies")
    public ResponseEntity<MovieDTO> createMovies(@RequestBody MovieDTO movieDTO) {
        MovieDTO savedMovies = movieService.createMovie(movieDTO);
        return new ResponseEntity<>(savedMovies, HttpStatus.CREATED);
    }

    // Get All Movies API
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    // Get Movie By ID API
    @GetMapping("{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable("id") String movieId) {
        MovieDTO movieDTO = movieService.getMovieById(movieId);
        return ResponseEntity.ok(movieDTO);
    }

    // Update Movie
    @PutMapping("/admin/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable("id") String movieId, @RequestBody MovieDTO updatedMovie) {
        MovieDTO movieDTO = movieService.updateMovie(movieId, updatedMovie);
        return ResponseEntity.ok(movieDTO);
    }

    // Delete Movie
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") String movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok("Movie deleted successfully!!");
    }
}

