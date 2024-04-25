package com.bookmyshow.platform.service.Impl;

import com.bookmyshow.platform.dto.CinemaDTO;
import com.bookmyshow.platform.exception.ResourceNotFoundException;
import com.bookmyshow.platform.mapper.CinemaMapper;
import com.bookmyshow.platform.model.Cinema;
import com.bookmyshow.platform.repository.CinemaRepository;
import com.bookmyshow.platform.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private CinemaRepository cinemaRepository;

    @Override
    public CinemaDTO createCinemas(CinemaDTO cinemaDTO) {
        Cinema cinema = CinemaMapper.mapToCinemas(cinemaDTO);
        Cinema savedCinemas = cinemaRepository.save(cinema);

        return CinemaMapper.mapToCinemaDto(savedCinemas);
    }

    @Override
    public List<CinemaDTO> getAllCinemas() {
        List<Cinema> cinemas = cinemaRepository.findAll();
        return cinemas.stream().map((cinema) -> CinemaMapper.mapToCinemaDto(cinema))
                .collect(Collectors.toList());
    }

    @Override
    public CinemaDTO getCinemaById(String cinemaId) {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cinema does not exits with the given ID : " + cinemaId));

        return CinemaMapper.mapToCinemaDto(cinema);
    }

    @Override
    public CinemaDTO updateCinema(String cinemaId, CinemaDTO updatedCinema) {
        Cinema cinema = cinemaRepository.findById(cinemaId).orElseThrow(
                () -> new ResourceNotFoundException("Cinema does not exists with the given ID : " + cinemaId)
        );

        // Update Operation
        cinema.setCinemaId(updatedCinema.getCinemaId());
        cinema.setName(updatedCinema.getName());
        cinema.setTotalCinemaHalls(updatedCinema.getTotalCinemaHalls());
        cinema.setLocation(updatedCinema.getLocation());

        Cinema updatedCinemaObj = cinemaRepository.save(cinema);

        return CinemaMapper.mapToCinemaDto(updatedCinemaObj);
    }

    @Override
    public void deleteCinema(String cinemaId) {
        Cinema cinema = cinemaRepository.findById(cinemaId).orElseThrow(
                () -> new ResourceNotFoundException("Cinema does not exists with the given ID : " + cinemaId)
        );

        cinemaRepository.deleteById(cinemaId);
    }
}
