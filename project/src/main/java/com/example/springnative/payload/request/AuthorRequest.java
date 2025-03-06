package com.example.springnative.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthorRequest {

    @NotBlank
    private String name;

    @NotNull
    private LocalDate dateOfBirth;
}
