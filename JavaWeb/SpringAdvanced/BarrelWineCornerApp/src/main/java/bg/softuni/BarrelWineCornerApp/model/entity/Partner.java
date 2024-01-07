package bg.softuni.BarrelWineCornerApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "partners")
public class Partner extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    private int phoneNumber;
    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;
    private String address;
}
