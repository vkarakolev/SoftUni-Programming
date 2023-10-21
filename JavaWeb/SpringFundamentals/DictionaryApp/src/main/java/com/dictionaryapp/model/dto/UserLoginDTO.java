package com.dictionaryapp.model.dto;

import jakarta.validation.constraints.Size;

public record UserLoginDTO(
        @Size(min = 3, max = 20)
        String username,
        @Size(min = 3, max = 20)
        String password
) {
}
