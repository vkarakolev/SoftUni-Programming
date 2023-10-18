package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.apache.catalina.User;
import org.softuni.mobilele.model.validation.FieldMatch;
import org.softuni.mobilele.model.validation.UniqueUserEmail;

@FieldMatch(first = "password", second = "confirmPassword", message = "Passwords should match.")
public record UserRegistrationDTO(
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        @NotEmpty(message = "Email is required.")
        @Email
        @UniqueUserEmail
        String email,
        @NotEmpty
        String password,
        @NotEmpty(message = "Password confirmation is required.")
        String confirmPassword) {

        public static UserRegistrationDTO empty() {
                return new UserRegistrationDTO(null, null,
                        null, null, null);
        }
}
