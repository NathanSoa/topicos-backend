package br.com.fatecmogidascruzes.ecommerce.category.useCases;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;
import br.com.fatecmogidascruzes.ecommerce.category.repository.CategoryRepository;

public class UpdateById {

    private final CategoryRepository repository;

    public UpdateById(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category execute(Category category, Long id) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        category.setId(id);
        return repository.save(category);
    }
}
