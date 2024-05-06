package bg.softuni.BarrelWineCornerApp.model.dto.view;

import bg.softuni.BarrelWineCornerApp.model.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserViewDTO {
    private Long id;
    private String username;
    private String email;
    private Role role;
}
