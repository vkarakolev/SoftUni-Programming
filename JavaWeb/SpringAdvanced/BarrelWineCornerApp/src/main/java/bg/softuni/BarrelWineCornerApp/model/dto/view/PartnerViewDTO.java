package bg.softuni.BarrelWineCornerApp.model.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
public class PartnerViewDTO {
    private String name;
    private String phoneNumber;
    private String address;
}
