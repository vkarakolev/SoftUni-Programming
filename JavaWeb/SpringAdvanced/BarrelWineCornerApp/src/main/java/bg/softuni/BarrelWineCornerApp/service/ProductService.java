package bg.softuni.BarrelWineCornerApp.service;

import bg.softuni.BarrelWineCornerApp.model.dto.CreateProductDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.ProductViewDTO;

import java.util.List;

public interface ProductService {
    List<ProductViewDTO> getAll();

    void addProduct(CreateProductDTO createProductDTO);
}
