package bg.softuni.BarrelWineCornerApp.service.impl;

import bg.softuni.BarrelWineCornerApp.model.dto.UserRegisterDTO;
import bg.softuni.BarrelWineCornerApp.model.entity.User;
import bg.softuni.BarrelWineCornerApp.repository.UserRepository;
import bg.softuni.BarrelWineCornerApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User user = modelMapper.map(userRegisterDTO, User.class);
        userRepository.save(user);
    }
}
