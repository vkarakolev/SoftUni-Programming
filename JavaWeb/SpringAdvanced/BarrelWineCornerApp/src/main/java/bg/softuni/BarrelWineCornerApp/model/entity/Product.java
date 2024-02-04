package bg.softuni.BarrelWineCornerApp.model.entity;

import bg.softuni.BarrelWineCornerApp.model.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductType type;
    @Column(nullable = false)
    private BigDecimal price;
    private String description;

//    TODO: manufacturer and imageUrl
    @ManyToOne
    private Partner manufacturer;

    private String imageUrl;
}
