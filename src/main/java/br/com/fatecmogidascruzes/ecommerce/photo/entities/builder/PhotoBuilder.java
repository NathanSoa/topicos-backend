package br.com.fatecmogidascruzes.ecommerce.photo.entities.builder;

import br.com.fatecmogidascruzes.ecommerce.photo.entities.Photo;

public class PhotoBuilder {
    private final Photo photo;

    private PhotoBuilder() {
        photo = new Photo();
    }

    public static PhotoBuilder of() {
        return new PhotoBuilder();
    }

    public PhotoBuilder withId(Long id) {
        photo.setId(id);
        return this;
    }

    public PhotoBuilder withFileName(String fileName) {
        photo.setFileName(fileName);
        return this;
    }

    public PhotoBuilder withOriginalFileName(String originalFileName) {
        photo.setOriginalFileName(originalFileName);
        return this;
    }

    public PhotoBuilder withSize(Long size) {
        photo.setSize(size);
        return this;
    }

    public PhotoBuilder withContentType(String contentType) {
        photo.setContentType(contentType);
        return this;
    }

    public Photo build() {
        return photo;
    }
}