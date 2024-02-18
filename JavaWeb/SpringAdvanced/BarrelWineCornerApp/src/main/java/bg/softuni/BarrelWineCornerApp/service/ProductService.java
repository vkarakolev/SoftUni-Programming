package bg.softuni.BarrelWineCornerApp.service;

import bg.softuni.BarrelWineCornerApp.model.dto.ActionProductDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.ProductViewDTO;

import java.util.List;

public interface ProductService {
    List<ProductViewDTO> getAll();

    void addProduct(ActionProductDTO createProductDTO);

    ProductViewDTO getById(Long id);
}
