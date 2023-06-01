package br.com.fatecmogidascruzes.ecommerce.product.useCases;

import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;
import br.com.fatecmogidascruzes.ecommerce.product.repository.ProductRepository;

import java.util.List;

public class FindAll {

    private final ProductRepository repository;

    public FindAll(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> execute() {
        return repository.findAll();
    }
}
