package xmlprocessing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xmlprocessing.entities.categories.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
