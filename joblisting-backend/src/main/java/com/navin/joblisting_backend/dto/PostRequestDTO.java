package com.navin.joblisting_backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostRequestDTO {

    @NotBlank(message = "Profile is mandatory")
    @Size(min = 2, max = 50, message = "Profile must be between 2 and 50 characters")
    private String profile;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String desc;

    @Min(value = 0, message = "Experience must be 0 or greater")
    private int exp;

    @NotEmpty(message = "Technologies list cannot be empty")
    private String[] techs;
}
