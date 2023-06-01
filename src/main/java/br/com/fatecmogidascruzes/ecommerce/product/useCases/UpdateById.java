package br.com.fatecmogidascruzes.ecommerce.product.useCases;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;
import br.com.fatecmogidascruzes.ecommerce.category.repository.CategoryRepository;
import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;
import br.com.fatecmogidascruzes.ecommerce.product.repository.ProductRepository;

public class UpdateById {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public UpdateById(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public Product execute(Product product, Long id) {
        Category category = categoryRepository.findById(product.getCategory().getId()).orElseThrow(RuntimeException::new);
        repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setId(id);
        product.setCategory(category);
        return repository.save(product);
    }
}
