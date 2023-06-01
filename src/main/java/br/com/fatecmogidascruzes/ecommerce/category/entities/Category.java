package br.com.fatecmogidascruzes.ecommerce.category.entities;

import br.com.fatecmogidascruzes.ecommerce.category.entities.dto.CategoryInputDTO;
import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String name;

    @NotBlank
    @Column(length = 200, nullable = false)
    private String photoURL;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {}

    public Category(String name, String photoURL) {
        setName(name);
        setPhotoURL(photoURL);
    }

    public Category(CategoryInputDTO categoryInputDTO) {
        setName(categoryInputDTO.getName());
        setPhotoURL(categoryInputDTO.getPhotoURL());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
