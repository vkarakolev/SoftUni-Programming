package bg.softuni.BarrelWineCornerApp.model.dto;

import bg.softuni.BarrelWineCornerApp.model.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRoleDTO {
    private Long id;
    private Role role;
}
