package br.com.fatecmogidascruzes.ecommerce.product.repository;

import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
