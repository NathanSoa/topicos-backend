package br.com.fatecmogidascruzes.ecommerce.product.entities;

import br.com.fatecmogidascruzes.ecommerce.category.entities.Category;
import br.com.fatecmogidascruzes.ecommerce.photo.entities.Photo;
import br.com.fatecmogidascruzes.ecommerce.product.entities.dto.ProductInputDTO;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 500)
	private String description;

	@NotNull
	@Min(0)
	private Double price;

	@NotNull
	private Boolean perishable;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToOne
	private Photo photo;

	Product() {}
	
	public Product(String name, 
			Double price, 
			Boolean perishable,
		   Category category) {
		setName(name);
		setPrice(price);
		setPerishable(perishable);
		setCategory(category);
	}

	public Product(ProductInputDTO productInputDTO) {
		setName(productInputDTO.getName());
		setDescription(productInputDTO.getDescription());
		setPrice(productInputDTO.getPrice());
		setPerishable(productInputDTO.getPerishable());
		Category category = new Category();
		category.setId(productInputDTO.getCategoryId());
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
