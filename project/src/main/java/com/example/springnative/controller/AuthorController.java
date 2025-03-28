package com.example.springnative.controller;

import com.example.springnative.payload.request.AuthorRequest;
import com.example.springnative.payload.response.AuthorResponse;
import com.example.springnative.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AuthorResponse create(@Valid @RequestBody AuthorRequest authorRequest) {
        return authorService.createAuthor(authorRequest);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<AuthorResponse> getAll() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/debug")
    public String debug(Authentication authentication) {
        return authentication.getAuthorities().toString();
    }
}
