package com.resellerapp.model.dto;

import com.resellerapp.model.entity.Offer;

public class OtherOfferDTO extends MyOfferDTO {
    private String username;

    public OtherOfferDTO() {

    }

    public OtherOfferDTO(Offer offer) {
        super(offer);
        this.username = offer.getCreatedBy().getUsername();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
