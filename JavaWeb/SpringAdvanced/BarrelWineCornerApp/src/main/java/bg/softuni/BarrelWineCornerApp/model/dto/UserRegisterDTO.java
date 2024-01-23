package bg.softuni.BarrelWineCornerApp.model.dto;

import bg.softuni.BarrelWineCornerApp.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRegisterDTO {
    @NotNull
    @Size(min = 2, max = 30)
    private String username;

    @Email
    @NotNull
    private String email;

    @Size(min = 2)
    private String password;

    @Size(min = 2)
    private String rePass;
    @NotNull
    private Role role;
}
