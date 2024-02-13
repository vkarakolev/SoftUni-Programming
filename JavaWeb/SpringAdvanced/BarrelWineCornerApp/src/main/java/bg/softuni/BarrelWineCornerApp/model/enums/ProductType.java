package bg.softuni.BarrelWineCornerApp.model.enums;

import java.util.List;

public enum ProductType {
    WINE, CHEESE, APPETIZER, BEER, WATER, SOFT_DRINK, BREAD, OTHERS;

    public static List<ProductType> getTypes() {
        return List.of(ProductType.WINE, ProductType.CHEESE, ProductType.APPETIZER, ProductType.BEER,
                ProductType.WATER, ProductType.SOFT_DRINK, ProductType.BREAD, ProductType.OTHERS);
    }
}

