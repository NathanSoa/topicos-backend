package br.com.fatecmogidascruzes.ecommerce.product.entities.dto;

import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;

public class ProductPM {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean perishable;
    private String photoURL;
    private String category;

    public ProductPM(Product product) {
        setId(product.getId());
        setName(product.getName());
        setDescription(product.getDescription());
        setPrice(product.getPrice());
        setPerishable(product.getPerishable());
        setPhotoURL("unsplash.com/photos/2zrXlHX5kBM");
        if(product.getPhoto() != null){
            setPhotoURL(product.getPhoto().getFileName());
        }
        String category = "No Category";
        if(product.getCategory() != null){
            category = product.getCategory().getName();
        }
        setCategory(category);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getPerishable() {
        return perishable;
    }

    public void setPerishable(Boolean perishable) {
        this.perishable = perishable;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
