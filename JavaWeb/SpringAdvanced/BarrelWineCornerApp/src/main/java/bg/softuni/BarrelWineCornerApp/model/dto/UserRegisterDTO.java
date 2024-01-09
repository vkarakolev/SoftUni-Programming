package bg.softuni.BarrelWineCornerApp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

}
