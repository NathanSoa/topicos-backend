package br.com.fatecmogidascruzes.ecommerce.category.repository;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
