package com.example.springnative.service;

import com.example.springnative.mapper.AuthorMapper;
import com.example.springnative.model.Author;
import com.example.springnative.payload.request.AuthorRequest;
import com.example.springnative.payload.response.AuthorResponse;
import com.example.springnative.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Transactional
    public AuthorResponse createAuthor(AuthorRequest authorRequest) {
        Author author = authorMapper.fromRequest(authorRequest);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toResponse(savedAuthor);
    }

    @Transactional(readOnly = true)
    public Author getAuthorById(Long authorId) {
        return authorRepository
                .findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("No author found with id: " + authorId));
    }

    @Transactional(readOnly = true)
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toResponse)
                .toList();
    }
}
