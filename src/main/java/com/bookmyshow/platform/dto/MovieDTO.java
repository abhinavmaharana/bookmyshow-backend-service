package com.bookmyshow.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class MovieDTO {
    private String id;
    private String title;
    private String description;
    private String durationInMinutes;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
}
