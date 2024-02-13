package bg.softuni.BarrelWineCornerApp.model.dto;

import bg.softuni.BarrelWineCornerApp.model.enums.ProductType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class CreateProductDTO {
    @NotNull
    private String name;

    @NotNull
    private ProductType type;

    @NotNull
    @Min(0)
    private BigDecimal price;

    private String description;

    @NotNull
    private String manufacturer;

    @NotNull
    private String imageUrl;
}
