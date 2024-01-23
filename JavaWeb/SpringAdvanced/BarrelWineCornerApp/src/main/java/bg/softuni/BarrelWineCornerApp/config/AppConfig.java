package bg.softuni.BarrelWineCornerApp.config;

import bg.softuni.BarrelWineCornerApp.model.dto.UserRegisterDTO;
import bg.softuni.BarrelWineCornerApp.model.entity.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();

        //UserRegisterDTO -> User
        Converter<String, String> passwordConverter =
                ctx -> (ctx.getSource() == null) ? null : passwordEncoder().encode(ctx.getSource());

        modelMapper
                .createTypeMap(UserRegisterDTO.class, User.class)
                .addMappings(mapper -> mapper
                        .using(passwordConverter)
                        .map(UserRegisterDTO::getPassword, User::setPassword));


        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
