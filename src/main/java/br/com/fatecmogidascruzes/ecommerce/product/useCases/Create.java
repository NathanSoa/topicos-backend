package br.com.fatecmogidascruzes.ecommerce.product.useCases;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;
import br.com.fatecmogidascruzes.ecommerce.category.repository.CategoryRepository;
import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;
import br.com.fatecmogidascruzes.ecommerce.product.repository.ProductRepository;

import java.io.FileNotFoundException;
public class Create {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public Create(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public Product execute(Product product) throws FileNotFoundException {
        System.out.println(product.getCategory().getId());
        var category = categoryRepository.findById(product.getCategory().getId());
        if(category.isEmpty()) {
            throw new FileNotFoundException("Category not found");
        }
        product.setCategory(category.get());
        return repository.save(product);
    }
}
