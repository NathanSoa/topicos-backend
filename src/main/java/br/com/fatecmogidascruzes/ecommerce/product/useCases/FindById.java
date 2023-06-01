package br.com.fatecmogidascruzes.ecommerce.product.useCases;

import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;
import br.com.fatecmogidascruzes.ecommerce.product.repository.ProductRepository;

public class FindById {

    private final ProductRepository repository;

    public FindById(ProductRepository repository) {
        this.repository = repository;
    }

    public Product execute(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
