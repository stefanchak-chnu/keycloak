package com.example.springnative.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {

    private Long id;
    private String title;
    private String releasedDate;
    private AuthorResponse authorResponse;
}
