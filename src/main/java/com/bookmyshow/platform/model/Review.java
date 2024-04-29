package com.bookmyshow.platform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Review {
    private String reviewerName;
    private int rating;
    private String comment;
}
