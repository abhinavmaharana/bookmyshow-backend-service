package com.bookmyshow.platform.repository;

import com.bookmyshow.platform.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmailAddress(String emailAddress);
}
