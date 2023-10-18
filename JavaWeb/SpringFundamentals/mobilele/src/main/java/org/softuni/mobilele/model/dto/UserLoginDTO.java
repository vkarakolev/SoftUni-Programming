package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.NotEmpty;

public record UserLoginDTO(
        @NotEmpty
        String email,
        @NotEmpty
        String password) {
}
