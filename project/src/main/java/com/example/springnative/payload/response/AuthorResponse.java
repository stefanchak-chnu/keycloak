package com.example.springnative.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorResponse {

    private Long id;
    private String name;
    private String dateOfBirth;
}
