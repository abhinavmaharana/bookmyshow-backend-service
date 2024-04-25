package com.bookmyshow.platform.mapper;

import com.bookmyshow.platform.dto.CinemaDTO;
import com.bookmyshow.platform.model.Cinema;

public class CinemaMapper {
    public static CinemaDTO mapToCinemaDto(Cinema cinema) {
        return new CinemaDTO(
                cinema.getCinemaId(),
                cinema.getName(),
                cinema.getTotalCinemaHalls(),
                cinema.getLocation()
        );
    }

    public static Cinema mapToCinemas(CinemaDTO cinemaDTO) {
        return new Cinema(
                cinemaDTO.getCinemaId(),
                cinemaDTO.getName(),
                cinemaDTO.getTotalCinemaHalls(),
                cinemaDTO.getLocation()
        );
    }
}
