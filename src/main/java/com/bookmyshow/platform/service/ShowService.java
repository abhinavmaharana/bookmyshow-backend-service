package com.bookmyshow.platform.service;

import com.bookmyshow.platform.dto.ShowsDTO;

import java.util.List;

public interface ShowService {
    ShowsDTO createShows(ShowsDTO showsDTO);
    List<ShowsDTO> getAllShows();
    ShowsDTO getShowById(String showId);
    ShowsDTO updateShow(String showId, ShowsDTO showsDTO);
    void deleteShow(String showId);
}
