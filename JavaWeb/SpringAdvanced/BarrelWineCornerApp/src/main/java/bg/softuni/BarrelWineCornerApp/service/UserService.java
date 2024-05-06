package bg.softuni.BarrelWineCornerApp.service;

import bg.softuni.BarrelWineCornerApp.model.dto.UserRegisterDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.UserRoleDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.UserViewDTO;
import bg.softuni.BarrelWineCornerApp.model.enums.Role;

import java.util.List;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);

    List<UserViewDTO> getAll();

    void updateRole(UserRoleDTO userRoleDTO);
}
