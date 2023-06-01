package br.com.fatecmogidascruzes.ecommerce.category.controller;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;
import br.com.fatecmogidascruzes.ecommerce.category.entities.dto.CategoryInputDTO;
import br.com.fatecmogidascruzes.ecommerce.category.entities.dto.CategoryPM;
import br.com.fatecmogidascruzes.ecommerce.category.repository.CategoryRepository;
import br.com.fatecmogidascruzes.ecommerce.category.useCases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository productRepository) {
        this.categoryRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<CategoryPM>> findAll() {
        List<Category> categories = new FindAll(categoryRepository).execute();
        return ResponseEntity.ok(categories.stream().map(CategoryPM::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryPM> findById(Long id) {
        Category category = new FindById(categoryRepository).execute(id);
        return ResponseEntity.ok(new CategoryPM(category));
    }

    @PostMapping
    public ResponseEntity<CategoryPM> save(@RequestBody CategoryInputDTO categoryInputDTO) {
        Category category = new Category(categoryInputDTO);
        Category dbCategory = new Create(categoryRepository).execute(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CategoryPM(dbCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryPM> save(@RequestBody CategoryInputDTO categoryInputDTO, @PathVariable Long id) {
        Category category = new Category(categoryInputDTO);
        Category dbCategory = new UpdateById(categoryRepository).execute(category, id);
        return ResponseEntity.ok(new CategoryPM(dbCategory));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id) {
        new DeleteById(categoryRepository).execute(id);
    }
}
