package org.softuni.mobilele.model.dto;

import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;

public record CreateOfferDTO(Long modelId, Integer price, EngineEnum engine, TransmissionEnum transmission,
                             Integer year, Integer mileage, String description, String imageUrl) {

}
