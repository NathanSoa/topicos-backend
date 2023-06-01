package br.com.fatecmogidascruzes.ecommerce.photo.repository;

import br.com.fatecmogidascruzes.ecommerce.photo.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
