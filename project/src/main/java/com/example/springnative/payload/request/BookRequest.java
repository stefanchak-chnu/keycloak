package com.example.springnative.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookRequest {

    @NotBlank
    private String title;

    @NotNull
    private LocalDate releasedDate;

    @NotNull
    private Long authorId;
}
