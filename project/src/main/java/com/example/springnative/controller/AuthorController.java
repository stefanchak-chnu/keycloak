package com.example.springnative.controller;

import com.example.springnative.payload.request.AuthorRequest;
import com.example.springnative.payload.response.AuthorResponse;
import com.example.springnative.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public AuthorResponse create(@Valid @RequestBody AuthorRequest authorRequest) {
        return authorService.createAuthor(authorRequest);
    }

    @GetMapping
    public List<AuthorResponse> getAll() {
        return authorService.getAllAuthors();
    }
}
