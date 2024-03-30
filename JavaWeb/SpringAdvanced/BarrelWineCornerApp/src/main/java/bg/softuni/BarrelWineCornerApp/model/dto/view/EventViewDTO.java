package bg.softuni.BarrelWineCornerApp.model.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
public class EventViewDTO {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private int maxPeopleCount;
    private String description;
    private String imageUrl;
}
