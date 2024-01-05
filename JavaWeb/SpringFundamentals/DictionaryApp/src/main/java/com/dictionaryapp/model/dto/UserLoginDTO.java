package com.dictionaryapp.model.dto;

import jakarta.validation.constraints.Size;

public record UserLoginDTO(
        @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
        String username,
        @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
        String password
) {
}
