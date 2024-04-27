package com.bookmyshow.platform.repository;

import com.bookmyshow.platform.model.Show;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowRepository extends MongoRepository<Show, String> {
}
