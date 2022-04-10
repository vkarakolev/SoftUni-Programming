package com.example.jsonandxmlprocessing.repositories;

import com.example.jsonandxmlprocessing.entities.categories.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
