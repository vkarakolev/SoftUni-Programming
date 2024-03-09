package bg.softuni.BarrelWineCornerApp.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ActionPartnerDTO {

    @NotNull
    private String name;

    @NotNull
    private int phoneNumber;

    private String address;
}
