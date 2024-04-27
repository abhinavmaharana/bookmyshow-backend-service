package com.bookmyshow.platform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Users")
public class User {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String countryMobileCode;
    private String password;
    private String mobileNumber;
    @Indexed
    private String emailAddress;
    private boolean active;
    private String role = "user";
    @CreatedDate
    private LocalDate createdDate;
}
