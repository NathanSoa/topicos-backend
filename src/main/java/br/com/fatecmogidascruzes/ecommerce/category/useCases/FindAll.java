package br.com.fatecmogidascruzes.ecommerce.category.useCases;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;
import br.com.fatecmogidascruzes.ecommerce.category.repository.CategoryRepository;

import java.util.List;

public class FindAll {

    private final CategoryRepository repository;

    public FindAll(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> execute() {
        return repository.findAll();
    }
}
