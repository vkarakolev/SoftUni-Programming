package com.example.jsonandxmlprocessing.services;

import com.example.jsonandxmlprocessing.entities.categories.CategoryStatsDTO;
import com.example.jsonandxmlprocessing.entities.products.ProductWithoutBuyerDTO;

import java.util.List;

public interface ProductService {
    List<ProductWithoutBuyerDTO> getProductsInPriceRangeForSale(float from, float to);

    List<CategoryStatsDTO> getCategoryStatistics();
}
