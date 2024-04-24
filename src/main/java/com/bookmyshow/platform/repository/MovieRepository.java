package com.bookmyshow.platform.repository;

import com.bookmyshow.platform.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
