package com.resellerapp.model.dto;

import com.resellerapp.model.enums.ConditionName;

import java.math.BigDecimal;

public record OfferAddDTO(
        String description,
        BigDecimal price,
        ConditionName condition
) {
}
