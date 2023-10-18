package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record BrandDTO(
        @NotEmpty
        String name,
        List<ModelDTO> models) {
}
