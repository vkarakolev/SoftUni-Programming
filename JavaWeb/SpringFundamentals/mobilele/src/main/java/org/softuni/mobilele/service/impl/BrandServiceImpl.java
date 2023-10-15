package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.ModelDTO;
import org.softuni.mobilele.model.entity.ModelEntity;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class BrandServiceImpl implements BrandService {

    private ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        Map<String, BrandDTO> brands = new TreeMap<>();

        for (ModelEntity model : modelRepository.findAll()) {
            String brandName = model.getBrand().getBrand();
            if(!brands.containsKey(brandName)) {
                brands.put(brandName, new BrandDTO(brandName, new ArrayList<>()));
            }

            brands.get(brandName).models().add(new ModelDTO(model.getId(), model.getName()));
        }

        return brands.values().stream().toList();
    }
}
