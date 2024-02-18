package bg.softuni.BarrelWineCornerApp.service.impl;

import bg.softuni.BarrelWineCornerApp.model.dto.ActionProductDTO;
import bg.softuni.BarrelWineCornerApp.model.dto.view.ProductViewDTO;
import bg.softuni.BarrelWineCornerApp.model.entity.Product;
import bg.softuni.BarrelWineCornerApp.repository.ProductRepository;
import bg.softuni.BarrelWineCornerApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @Override
    public List<ProductViewDTO> getAll() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductViewDTO.class))
                .toList();
    }

    @Override
    public void addProduct(ActionProductDTO createProductDTO) {
        Product product = modelMapper.map(createProductDTO, Product.class);
        productRepository.save(product);
    }

    @Override
    public ProductViewDTO getById(Long id) {
        return productRepository.findById(id)
                .map(product -> modelMapper.map(product, ProductViewDTO.class))
                .orElseThrow();
    }
}
