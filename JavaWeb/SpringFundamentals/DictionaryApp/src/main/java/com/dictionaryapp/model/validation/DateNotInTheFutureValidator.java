package com.dictionaryapp.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.util.Date;

public class DateNotInTheFutureValidator implements ConstraintValidator<DateNotInTheFuture, Number> {

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }

        LocalDate currentDate = LocalDate.now();
        return true;
    }
}
