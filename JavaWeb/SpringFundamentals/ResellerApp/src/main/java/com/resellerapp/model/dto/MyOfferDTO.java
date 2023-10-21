package com.resellerapp.model.dto;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionName;

import java.util.UUID;

public class MyOfferDTO extends BoughtOfferDTO {
    private ConditionName condition;
    private UUID id;

    public MyOfferDTO() {
    }

    public MyOfferDTO  (Offer offer) {
        super(offer);
        id = offer.getId();
        this.condition = offer.getCondition().getName();

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ConditionName getCondition() {
        return condition;
    }

    public void setCondition(ConditionName condition) {
        this.condition = condition;
    }
}
