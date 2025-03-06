package com.example.springnative.mapper;

import com.example.springnative.model.Book;
import com.example.springnative.payload.request.BookRequest;
import com.example.springnative.payload.response.AuthorResponse;
import com.example.springnative.payload.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper {

    private final AuthorMapper authorMapper;

    public Book fromRequest(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setReleasedDate(bookRequest.getReleasedDate());
        return book;
    }

    public BookResponse toResponse(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setReleasedDate(book.getReleasedDate().toString());

        AuthorResponse authorResponse = authorMapper.toResponse(book.getAuthor());
        bookResponse.setAuthorResponse(authorResponse);

        return bookResponse;
    }
}
