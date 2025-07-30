package com.ikm.bookApp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviewdto {
    @NotBlank
    private String reviewerName;
    private int rating;
    private String comment;
}
