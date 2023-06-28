package com.example.demo.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull
    private Integer userId;
    @NotBlank
    private String userName;
    @NotNull
    private LocalDate dateOfBirth;
    @Email
    private String email;
    @Size(min = 12, max = 12, message = "Phone number must be 12 digits.")
    private String phoneNumber;
    @NotNull(message="Invalid format must be in YYYY-MM-DD format")
    private LocalDate date;
    @NotNull(message="Invalid format must be in HH:MM:SS format")
    private LocalTime time;
}
