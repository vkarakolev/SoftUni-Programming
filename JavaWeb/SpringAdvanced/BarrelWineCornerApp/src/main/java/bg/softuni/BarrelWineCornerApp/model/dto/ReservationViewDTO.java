package bg.softuni.BarrelWineCornerApp.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ReservationViewDTO {
    private String email;
    private String clientName;
    private int peopleCount;
    private LocalDate date;
    private LocalTime time;
    private boolean approved;

}
