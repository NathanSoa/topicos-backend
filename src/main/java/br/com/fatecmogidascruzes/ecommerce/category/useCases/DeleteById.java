package br.com.fatecmogidascruzes.ecommerce.category.useCases;

import br.com.fatecmogidascruzes.ecommerce.category.repository.CategoryRepository;

public class DeleteById {

    private final CategoryRepository repository;

    public DeleteById(CategoryRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}
