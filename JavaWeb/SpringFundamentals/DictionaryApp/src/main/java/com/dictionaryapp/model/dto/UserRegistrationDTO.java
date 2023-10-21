package com.dictionaryapp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRegistrationDTO(
        @NotNull
        @Size(min = 3, max = 20)
        String username,
        @NotNull
        @Email
        String email,
        @NotNull
        @Size(min = 3, max = 20)
        String password,
        @NotNull
        @Size(min = 3, max = 20)
        String confirmPassword
) {
}
