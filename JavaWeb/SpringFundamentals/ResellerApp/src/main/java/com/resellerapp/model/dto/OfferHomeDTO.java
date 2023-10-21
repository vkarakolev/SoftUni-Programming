package com.resellerapp.model.dto;

import java.util.List;
public record OfferHomeDTO(
        List<MyOfferDTO> myOffers,
        List<BoughtOfferDTO> boughtOffers,
        List<OtherOfferDTO> allOtherOffers,
        long totalOffers
) {
}
