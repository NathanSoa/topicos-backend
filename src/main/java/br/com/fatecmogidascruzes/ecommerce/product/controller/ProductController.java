package br.com.fatecmogidascruzes.ecommerce.product.controller;

import br.com.fatecmogidascruzes.ecommerce.category.repository.CategoryRepository;
import br.com.fatecmogidascruzes.ecommerce.photo.repository.PhotoRepository;
import br.com.fatecmogidascruzes.ecommerce.photo.useCases.Download;
import br.com.fatecmogidascruzes.ecommerce.photo.useCases.Upload;
import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;
import br.com.fatecmogidascruzes.ecommerce.product.entities.dto.ProductInputDTO;
import br.com.fatecmogidascruzes.ecommerce.product.entities.dto.ProductPM;
import br.com.fatecmogidascruzes.ecommerce.product.repository.ProductRepository;
import br.com.fatecmogidascruzes.ecommerce.product.useCases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PhotoRepository photoRepository;

    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository, PhotoRepository photoRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.photoRepository = photoRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProductPM>> findAll() {
        List<Product> products = new FindAll(productRepository).execute();
        return ResponseEntity.ok(products.stream().map(ProductPM::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPM> findById(Long id) {
        Product product = new FindById(productRepository).execute(id);
        return ResponseEntity.ok(new ProductPM(product));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/photo")
    public void findPhotoById(@PathVariable Long id, HttpServletResponse response) throws IOException {
        System.out.println("id = " + id);
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        new Download().execute(product.getPhoto(), response);
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<ProductPM> save(@ModelAttribute ProductInputDTO productInputDTO) throws IOException {
        Product product = new Product(productInputDTO);
        product.setPhoto(new Upload(photoRepository).execute(productInputDTO.getPhoto()));
        Product dbProduct = new Create(productRepository, categoryRepository).execute(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductPM(dbProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductPM> save(@RequestBody ProductInputDTO productInputDTO, @PathVariable Long id) {
        Product product = new Product(productInputDTO);
        Product dbProduct = new UpdateById(productRepository, categoryRepository).execute(product, id);
        return ResponseEntity.ok(new ProductPM(dbProduct));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        new DeleteById(productRepository).execute(id);
    }
}
