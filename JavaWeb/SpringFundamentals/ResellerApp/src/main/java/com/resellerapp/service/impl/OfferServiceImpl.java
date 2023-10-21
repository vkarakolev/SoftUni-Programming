package com.resellerapp.service.impl;

import com.resellerapp.model.dto.*;
import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.OfferService;
import com.resellerapp.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    private final ConditionRepository conditionRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public OfferServiceImpl(ConditionRepository conditionRepository, OfferRepository offerRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.conditionRepository = conditionRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public OfferHomeDTO getOffersForHomePage() {
        List<Offer> offers = offerRepository.findAll();
        List<MyOfferDTO> myOffers = new ArrayList<>();
        List<BoughtOfferDTO> boughtOffers = new ArrayList<>();
        List<OtherOfferDTO> otherOffers = new ArrayList<>();

        String loggedUserUsername = loggedUser.getUsername();

        offers.forEach(offer -> {
                    if(offer.getBoughtBy() == null && offer.getCreatedBy().getUsername().equals(loggedUserUsername)) {
                        myOffers.add(new MyOfferDTO(offer));
                    } else if(offer.getBoughtBy() != null &&
                            offer.getBoughtBy().getUsername().equals(loggedUserUsername)) {
                        boughtOffers.add(new BoughtOfferDTO(offer));
                    } else if(offer.getBoughtBy() == null) {
                        otherOffers.add(new OtherOfferDTO(offer));
                    }
                });

        return new OfferHomeDTO(myOffers, boughtOffers, otherOffers, otherOffers.size());
    }

    @Override
    public boolean add(OfferAddDTO offerAddDTO) {
        Condition condition = conditionRepository.findByName(offerAddDTO.condition());
        User user = userRepository.findByUsername(loggedUser.getUsername());

        if(condition != null && user != null) {
            offerRepository.save(map(offerAddDTO, condition, user));
            return true;
        }
        return false;
    }

    @Override
    public void buy(UUID id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);

        if(optionalOffer.isPresent()) {
            Offer offer = optionalOffer.get();
            User user = userRepository.findByUsername(loggedUser.getUsername());

            offer.setBoughtBy(user);

            offerRepository.save(offer);
        }
    }

    @Override
    public void remove(UUID id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);

        if(optionalOffer.isPresent()) {
            Offer offer = optionalOffer.get();
            User user = userRepository.findByUsername(loggedUser.getUsername());

            if(user.getUsername().equals(offer.getCreatedBy().getUsername())) {
                offerRepository.delete(offer);
            }
        }
    }

    private Offer map(OfferAddDTO offerAddDTO, Condition condition, User user) {
        return new Offer()
                .setDescription(offerAddDTO.description())
                .setCreatedBy(user)
                .setCondition(condition)
                .setPrice(offerAddDTO.price());
    }
}
