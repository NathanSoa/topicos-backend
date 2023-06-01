package br.com.fatecmogidascruzes.ecommerce.product.useCases;

import br.com.fatecmogidascruzes.ecommerce.product.repository.ProductRepository;

public class DeleteById {

    private final ProductRepository repository;

    public DeleteById(ProductRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}
