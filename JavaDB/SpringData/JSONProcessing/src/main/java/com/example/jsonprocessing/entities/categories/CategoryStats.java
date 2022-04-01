package com.example.jsonprocessing.entities.categories;

import java.math.BigDecimal;

public class CategoryStats {
    private final String category;
    private final long productCount;
    private final double averagePrice;
    private final BigDecimal totalRevenue;

    public CategoryStats(String category, long productCount, double averagePrice, BigDecimal totalRevenue) {
        this.category = category;
        this.productCount = productCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

    public String getCategory() {
        return category;
    }

    public long getProductCount() {
        return productCount;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }
}
