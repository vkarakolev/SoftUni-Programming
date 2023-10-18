package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ModelDTO(
        @NotNull
        long id,
        @NotEmpty
        String name) {
}
