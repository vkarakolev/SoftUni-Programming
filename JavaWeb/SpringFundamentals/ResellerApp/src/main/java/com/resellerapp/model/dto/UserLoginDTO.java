package com.resellerapp.model.dto;

import org.hibernate.validator.constraints.Length;

public record UserLoginDTO(
        @Length(min = 3, max = 20)
        String username,
        @Length(min = 3, max = 20)
        String password
) {
}
