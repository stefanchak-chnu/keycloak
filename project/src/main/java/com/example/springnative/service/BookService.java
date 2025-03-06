package com.example.springnative.service;

import com.example.springnative.mapper.BookMapper;
import com.example.springnative.model.Author;
import com.example.springnative.model.Book;
import com.example.springnative.payload.request.BookRequest;
import com.example.springnative.payload.response.BookResponse;
import com.example.springnative.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final BookMapper bookMapper;

    @Transactional
    public BookResponse createBook(BookRequest bookRequest) {
        Author author = authorService.getAuthorById(bookRequest.getAuthorId());

        Book book = bookMapper.fromRequest(bookRequest);
        book.setAuthor(author);

        Book savedBook = bookRepository.save(book);

        return bookMapper.toResponse(savedBook);
    }

    @Transactional(readOnly = true)
    public List<BookResponse> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(bookMapper::toResponse)
                .toList();
    }
}
