package com.bookmyshow.platform.mapper;

import com.bookmyshow.platform.dto.ShowsDTO;
import com.bookmyshow.platform.model.Show;

public class ShowsMapper {
    public static ShowsDTO mapToShowsDto(Show show) {
        return new ShowsDTO(
                show.getShowId(),
                show.getCreatedAt(),
                show.getStartTime(),
                show.getEndTime(),
                show.getMovieId()
        );
    }

    public static Show mapToShows(ShowsDTO showsDTO) {
        return new Show(
                showsDTO.getShowId(),
                showsDTO.getCreatedAt(),
                showsDTO.getStartTime(),
                showsDTO.getEndTime(),
                showsDTO.getMovieId()
        );
    }
}
