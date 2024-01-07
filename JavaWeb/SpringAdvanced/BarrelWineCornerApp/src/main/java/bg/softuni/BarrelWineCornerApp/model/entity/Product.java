package bg.softuni.BarrelWineCornerApp.model.entity;

import bg.softuni.BarrelWineCornerApp.model.enums.ProductType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductType type;
    @Column(nullable = false)
    @Min(0)
    private BigDecimal price;
    private String description;
    @Column(nullable = false)
    @ManyToOne
    private Partner manufacturer;
}
