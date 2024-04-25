package com.bookmyshow.platform.service;

import com.bookmyshow.platform.dto.CinemaDTO;

import java.util.List;

public interface CinemaService {
    CinemaDTO createCinemas(CinemaDTO cinemaDTO);
    List<CinemaDTO> getAllCinemas();
    CinemaDTO getCinemaById(String cinemaId);
    CinemaDTO updateCinema(String cinemaId, CinemaDTO cinemaDTO);
    void deleteCinema(String cinemaId);
}
