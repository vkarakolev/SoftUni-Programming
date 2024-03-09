package bg.softuni.BarrelWineCornerApp.service;

import bg.softuni.BarrelWineCornerApp.model.dto.ActionPartnerDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.PartnerViewDTO;

import java.util.List;

public interface PartnerService {

    List<PartnerViewDTO> getAll();

    void addPartner(ActionPartnerDTO actionPartnerDTO);
}
