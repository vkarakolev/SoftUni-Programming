package bg.softuni.BarrelWineCornerApp.service.impl;

import bg.softuni.BarrelWineCornerApp.model.dto.ActionPartnerDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.PartnerViewDTO;
import bg.softuni.BarrelWineCornerApp.model.entity.Partner;
import bg.softuni.BarrelWineCornerApp.repository.PartnerRepository;
import bg.softuni.BarrelWineCornerApp.repository.ProductRepository;
import bg.softuni.BarrelWineCornerApp.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final ModelMapper modelMapper;
    private final PartnerRepository partnerRepository;

    @Override
    public List<PartnerViewDTO> getAll() {
        return partnerRepository.findAll().stream()
                .map(partner -> modelMapper.map(partner, PartnerViewDTO.class))
                .toList();
    }

    @Override
    public void addPartner(ActionPartnerDTO actionPartnerDTO) {
        Partner partner = modelMapper.map(actionPartnerDTO, Partner.class);
        partnerRepository.save(partner);
    }
}
