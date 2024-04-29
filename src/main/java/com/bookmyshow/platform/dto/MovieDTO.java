package com.bookmyshow.platform.dto;

import com.bookmyshow.platform.model.CastCrew;
import com.bookmyshow.platform.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MovieDTO {
    private String id;
    private String title;
    private String description;
    private String certification;
    private List<CastCrew> cast;
    private List<CastCrew> crew;
    private List<Review> reviews;
    private String durationInMinutes;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
}
