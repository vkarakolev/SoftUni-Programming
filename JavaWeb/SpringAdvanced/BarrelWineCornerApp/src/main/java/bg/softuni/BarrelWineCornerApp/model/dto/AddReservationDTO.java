package bg.softuni.BarrelWineCornerApp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
public class AddReservationDTO {
    @Email
    private String email;

    @NotNull
    private String name;

    @NotNull
    @Min(1)
    private int peopleCount;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime time;
}
