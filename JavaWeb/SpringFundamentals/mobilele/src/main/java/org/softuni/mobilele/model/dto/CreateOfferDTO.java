package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.*;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;
import org.softuni.mobilele.model.validation.YearNotInTheFuture;

public record CreateOfferDTO(
        @Positive
        @NotNull
        Long modelId,
        @Positive
        @NotNull
        Integer price,
        @NotNull
        EngineEnum engine,
        @NotNull
        TransmissionEnum transmission,
        @NotNull(message = "Manufacturing year is required.")
        @Min(value = 1930, message = "Manufacturing year must be after 1929.")
        @YearNotInTheFuture
        Integer year,
        @Positive
        @NotNull
        Integer mileage,
        @NotEmpty
        @Size(min = 5, max = 500)
        String description,
        @NotEmpty
        String imageUrl
) {
        public static CreateOfferDTO empty() {
                return new CreateOfferDTO(null, null, null, null,
                        null, null, null, null);
        }
}
