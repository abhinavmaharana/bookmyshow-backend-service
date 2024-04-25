package com.bookmyshow.platform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Cinemas")
public class Cinema {
    @Id
    private String cinemaId;
    private String name;
    private int totalCinemaHalls;
    private String location;
}
