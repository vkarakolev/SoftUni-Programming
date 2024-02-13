package bg.softuni.BarrelWineCornerApp.model.enums;

import java.util.List;

public enum Role {
    USER, MODERATOR, ADMIN;

    public static List<Role> getRoles() {
        return List.of(Role.USER, Role.MODERATOR, Role.ADMIN);
    }
}
