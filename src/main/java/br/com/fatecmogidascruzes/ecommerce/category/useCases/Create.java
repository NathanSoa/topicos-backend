package br.com.fatecmogidascruzes.ecommerce.category.useCases;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;
import br.com.fatecmogidascruzes.ecommerce.category.repository.CategoryRepository;

public class Create {

    private final CategoryRepository repository;

    public Create(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category execute(Category category) {
        return repository.save(category);
    }
}
