package com.biblioteca.dto;

public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer publicationYear;
    private String category;
    private Boolean available;

    public BookResponse(Long id, String title, String author, String isbn,
                        Integer publicationYear, String category, Boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.category = category;
        this.available = available;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public Integer getPublicationYear() { return publicationYear; }
    public String getCategory() { return category; }
    public Boolean getAvailable() { return available; }
}
