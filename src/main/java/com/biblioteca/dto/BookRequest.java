package com.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookRequest {
    @NotBlank(message = "title es obligatorio")
    private String title;
    @NotBlank(message = "author es obligatorio")
    private String author;
    @NotBlank(message = "isbn es obligatorio")
    private String isbn;
    @NotNull(message = "publicationYear es obligatorio")
    @Positive(message = "publicationYear debe ser positivo")
    private Integer publicationYear;
    @NotBlank(message = "category es obligatorio")
    private String category;
    @NotNull(message = "available es obligatorio")
    private Boolean available;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public Integer getPublicationYear() { return publicationYear; }
    public void setPublicationYear(Integer publicationYear) { this.publicationYear = publicationYear; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}
