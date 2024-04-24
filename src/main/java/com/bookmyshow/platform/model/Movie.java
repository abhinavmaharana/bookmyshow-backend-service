package com.bookmyshow.platform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Movies")
public class Movie {
    @Id
    private String id;
    private String title;
    private String description;
    private String durationInMinutes;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
}
