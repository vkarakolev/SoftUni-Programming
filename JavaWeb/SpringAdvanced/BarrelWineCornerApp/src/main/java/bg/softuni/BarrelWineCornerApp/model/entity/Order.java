package bg.softuni.BarrelWineCornerApp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "myOrders")
    private User madeBy;
    @ManyToMany(mappedBy = "orders")
    private List<Product> products;
}
