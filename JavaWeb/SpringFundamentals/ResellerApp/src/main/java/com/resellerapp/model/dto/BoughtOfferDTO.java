package com.resellerapp.model.dto;

import com.resellerapp.model.entity.Offer;

import java.math.BigDecimal;

public class BoughtOfferDTO {
    private String description;
    private BigDecimal price;

    public BoughtOfferDTO() {
    }
    public BoughtOfferDTO(Offer offer) {
        this.description = offer.getDescription();
        this.price = offer.getPrice();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
