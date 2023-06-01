package br.com.fatecmogidascruzes.ecommerce;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;
import br.com.fatecmogidascruzes.ecommerce.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count() == 0) {
            Category category = new Category();
            category.setName("Carros");
            category.setPhotoURL("unsplash.com/photos/2zrXlHX5kBM");
            categoryRepository.save(category);

            Category category2 = new Category();
            category2.setName("Motos");
            category.setPhotoURL("unsplash.com/photos/2zrXlHX5kBM");
            categoryRepository.save(category2);

        }
    }
}
