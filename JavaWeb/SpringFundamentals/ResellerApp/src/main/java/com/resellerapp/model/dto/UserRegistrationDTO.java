package com.resellerapp.model.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public record UserRegistrationDTO (
    @Length(min = 3, max = 20)
    String username,
    @Email
    String email,
    @Length(min = 3, max = 20)
    String password,
    String confirmPassword) {
}
