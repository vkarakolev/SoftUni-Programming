package com.example.jsonandxmlprocessing.services.impl;

import com.example.jsonandxmlprocessing.entities.categories.CategoryStatsDTO;
import com.example.jsonandxmlprocessing.entities.products.ProductWithoutBuyerDTO;
import com.example.jsonandxmlprocessing.repositories.ProductRepository;
import com.example.jsonandxmlprocessing.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductWithoutBuyerDTO> getProductsInPriceRangeForSale(float from, float to) {
        BigDecimal rangeStart = BigDecimal.valueOf(from);
        BigDecimal rangeEnd = BigDecimal.valueOf(to);

        return this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(rangeStart, rangeEnd);
    }

    @Override
    public List<CategoryStatsDTO> getCategoryStatistics() {
        return productRepository.getCategoryStats();
    }
}
