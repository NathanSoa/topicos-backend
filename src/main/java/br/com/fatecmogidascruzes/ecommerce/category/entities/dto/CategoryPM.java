package br.com.fatecmogidascruzes.ecommerce.category.entities.dto;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;

public class CategoryPM {

    private Long id;
    private String name;
    private String photoUrl;

    public CategoryPM(Long id, String name, String photoUrl) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public CategoryPM() {}

    public CategoryPM(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.photoUrl = category.getPhotoURL();
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
