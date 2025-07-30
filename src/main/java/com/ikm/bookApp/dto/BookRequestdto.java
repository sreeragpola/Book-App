package com.ikm.bookApp.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestdto {
    @NotBlank
    @Pattern(regexp = "^\\d{13}")
    private String isbn;
    @NotBlank
    private String title;
    private String author;
    @NotNull
    private Long publicationYear;
    private List<Reviewdto> initialReview;
}
