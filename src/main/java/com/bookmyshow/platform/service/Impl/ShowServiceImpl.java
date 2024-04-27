package com.bookmyshow.platform.service.Impl;

import com.bookmyshow.platform.dto.ShowsDTO;
import com.bookmyshow.platform.exception.ResourceNotFoundException;
import com.bookmyshow.platform.mapper.ShowsMapper;
import com.bookmyshow.platform.model.Show;
import com.bookmyshow.platform.repository.ShowRepository;
import com.bookmyshow.platform.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {
    private ShowRepository showRepository;

    @Override
    public ShowsDTO createShows(ShowsDTO showsDTO) {
        Show show = ShowsMapper.mapToShows(showsDTO);
        Show savedShows = showRepository.save(show);

        return ShowsMapper.mapToShowsDto(savedShows);
    }

    @Override
    public List<ShowsDTO> getAllShows() {
        List<Show> shows = showRepository.findAll();
        return shows.stream().map((show) -> ShowsMapper.mapToShowsDto(show))
                .collect(Collectors.toList());
    }

    @Override
    public ShowsDTO getShowById(String showId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new ResourceNotFoundException("Show does not exists with the given id : " + showId));

        return ShowsMapper.mapToShowsDto(show);
    }

    // TODO: FIX THE UPDATE SHOW
    @Override
    public ShowsDTO updateShow(String showId, ShowsDTO updatedShow) {
        Show show = showRepository.findById(showId).orElseThrow(
                () -> new ResourceNotFoundException("Show does not exists with the given id : " + showId)
        );

        return null;
    }

    @Override
    public void deleteShow(String showId) {
        Show show = showRepository.findById(showId).orElseThrow(
                () -> new ResourceNotFoundException("Show does not exists with the given id : " + showId)
        );

        showRepository.deleteById(showId);
    }
}
