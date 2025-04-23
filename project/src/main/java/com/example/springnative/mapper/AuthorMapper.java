package com.example.springnative.mapper;

import com.example.springnative.model.Author;
import com.example.springnative.payload.request.AuthorRequest;
import com.example.springnative.payload.response.AuthorResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author fromRequest(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setDateOfBirth(authorRequest.getDateOfBirth());
        return author;
    }

    public AuthorResponse toResponse(Author author) {
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setId(author.getId());
        authorResponse.setName(author.getName());
        authorResponse.setDateOfBirth(author.getDateOfBirth().toString());

        authorResponse.setCreatedBy(author.getCreatedBy());
        authorResponse.setCreatedDate(author.getCreatedDate());
        authorResponse.setLastModifiedBy(author.getLastModifiedBy());
        authorResponse.setLastModifiedDate(author.getLastModifiedDate());

        return authorResponse;
    }
}
