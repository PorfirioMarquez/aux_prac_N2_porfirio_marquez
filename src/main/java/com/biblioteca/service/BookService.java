package com.biblioteca.service;

import com.biblioteca.dto.BookRequest;
import com.biblioteca.dto.BookResponse;
import com.biblioteca.exception.BookNotFoundException;
import com.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public synchronized BookResponse create(BookRequest request) {
        Book book = new Book(sequence.getAndIncrement(), request.getTitle(), request.getAuthor(),
                request.getIsbn(), request.getPublicationYear(), request.getCategory(),
                request.getAvailable());
        books.add(book);
        return toResponse(book);
    }

    public synchronized List<BookResponse> findAll() {
        return books.stream().map(this::toResponse).toList();
    }

    public synchronized BookResponse findById(Long id) {
        return toResponse(getOrThrow(id));
    }

    public synchronized BookResponse update(Long id, BookRequest request) {
        Book book = getOrThrow(id);
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setPublicationYear(request.getPublicationYear());
        book.setCategory(request.getCategory());
        book.setAvailable(request.getAvailable());
        return toResponse(book);
    }

    public synchronized void delete(Long id) {
        books.remove(getOrThrow(id));
    }

    private Book getOrThrow(Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private BookResponse toResponse(Book b) {
        return new BookResponse(b.getId(), b.getTitle(), b.getAuthor(), b.getIsbn(),
                b.getPublicationYear(), b.getCategory(), b.getAvailable());
    }
}
