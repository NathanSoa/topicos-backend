package br.com.fatecmogidascruzes.ecommerce.product.entities.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductInputDTO {

    private String name;
    private String description;
    private Double price;
    private Boolean perishable;
    private MultipartFile photo;

    private Long categoryId;

    ProductInputDTO() {}

    public ProductInputDTO(String name,
                   Double price,
                   Boolean perishable,
                   MultipartFile photo,
                   Long categoryId){
        setName(name);
        setPrice(price);
        setPerishable(perishable);
        setPhoto(photo);
        setCategoryId(categoryId);
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

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
