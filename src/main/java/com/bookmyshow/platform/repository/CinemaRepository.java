package com.bookmyshow.platform.repository;

import com.bookmyshow.platform.model.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CinemaRepository extends MongoRepository<Cinema, String> {
}
