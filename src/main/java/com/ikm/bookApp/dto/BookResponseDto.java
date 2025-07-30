package com.ikm.bookApp.dto;

import java.util.List;

public class BookResponseDto {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private List<Reviewdto> reviews;
    private Double averageRating;
    private int totalReviewCount;  
}
