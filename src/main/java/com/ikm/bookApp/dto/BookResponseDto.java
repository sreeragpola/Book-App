package com.ikm.bookApp.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private String isbn;
    private String title;
    private String author;
    private Long publicationYear;
    private List<Reviewdto> reviews;
    private Double averageRating;
    private int totalReviewCount;  
}
