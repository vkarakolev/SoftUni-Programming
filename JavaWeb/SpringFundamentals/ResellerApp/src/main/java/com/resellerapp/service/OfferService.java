package com.resellerapp.service;

import com.resellerapp.model.dto.OfferAddDTO;
import com.resellerapp.model.dto.OfferHomeDTO;

import java.util.UUID;

public interface OfferService {
    OfferHomeDTO getOffersForHomePage();

    boolean add(OfferAddDTO offerAddDTO);

    void buy(UUID id);

    void remove(UUID id);
}
