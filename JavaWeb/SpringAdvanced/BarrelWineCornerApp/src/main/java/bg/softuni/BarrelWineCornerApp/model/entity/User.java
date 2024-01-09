package bg.softuni.BarrelWineCornerApp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToOne
    private Reservation reservation;
    @OneToMany(mappedBy = "madeBy")
    private List<Order> myOrders;
}
