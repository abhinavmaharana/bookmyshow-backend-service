package com.bookmyshow.platform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Movies")
public class Movie {
    @Id
    private String id;
    private String title;
    private String description;
    private String certification;
    private String posterImg;
    private String heroBannerImg;
    private List<CastCrew> cast;
    private List<CastCrew> crew;
    private List<Review> reviews;
    private String durationInMinutes;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
}
