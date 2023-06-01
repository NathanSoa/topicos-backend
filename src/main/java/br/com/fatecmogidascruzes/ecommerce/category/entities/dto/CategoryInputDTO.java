package br.com.fatecmogidascruzes.ecommerce.category.entities.dto;

public class CategoryInputDTO {

    private String name;
    private String photoURL;

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
}
