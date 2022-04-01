package com.example.jsonprocessing.services;

import com.example.jsonprocessing.entities.categories.CategoryStats;
import com.example.jsonprocessing.entities.products.ProductWithoutBuyerDTO;

import java.util.List;

public interface ProductService {
    List<ProductWithoutBuyerDTO> getProductsInPriceRangeForSale(float from, float to);

    List<CategoryStats> getCategoryStatistics();
}
