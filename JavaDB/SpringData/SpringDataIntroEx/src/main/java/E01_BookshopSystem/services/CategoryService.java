package E01_BookshopSystem.services;

import E01_BookshopSystem.entities.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();
}
