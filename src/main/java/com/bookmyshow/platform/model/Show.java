package com.bookmyshow.platform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Shows")
public class Show {
    @Id
    private String showId;
    private Date createdAt;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String movieId;
}
