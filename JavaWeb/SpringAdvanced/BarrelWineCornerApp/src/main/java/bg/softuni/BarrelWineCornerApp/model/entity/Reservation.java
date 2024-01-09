package bg.softuni.BarrelWineCornerApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String clientName;
    @Column(nullable = false)
    private int peopleCount;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime hour;
    @OneToOne(mappedBy = "reservation")
    private User createdBy;
}
