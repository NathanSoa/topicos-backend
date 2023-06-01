package br.com.fatecmogidascruzes.ecommerce.category.useCases;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;
import br.com.fatecmogidascruzes.ecommerce.category.repository.CategoryRepository;

public class FindById {

    private final CategoryRepository repository;

    public FindById(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category execute(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
