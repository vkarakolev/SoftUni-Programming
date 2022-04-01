package com.example.jsonprocessing.services.impl;

import com.example.jsonprocessing.entities.categories.CategoryStats;
import com.example.jsonprocessing.entities.products.ProductWithoutBuyerDTO;
import com.example.jsonprocessing.repositories.ProductRepository;
import com.example.jsonprocessing.services.ProductService;
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
    public List<CategoryStats> getCategoryStatistics() {
        return productRepository.getCategoryStats();
    }
}
