package com.bookmyshow.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CinemaDTO {
    private String cinemaId;
    private String name;
    private int totalCinemaHalls;
    private String location;
}
