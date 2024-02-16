package bg.softuni.BarrelWineCornerApp.model.dto.view;

import bg.softuni.BarrelWineCornerApp.model.entity.Partner;
import bg.softuni.BarrelWineCornerApp.model.enums.ProductType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ProductViewDTO {
    private String name;
    private ProductType type;
    private BigDecimal price;
    private String description;
    private String manufacturer;
    private String imageUrl;
}
