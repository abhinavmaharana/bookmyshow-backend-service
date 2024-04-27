package com.bookmyshow.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ShowsDTO {
    private String showId;
    private Date createdAt;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String movieId;
}
