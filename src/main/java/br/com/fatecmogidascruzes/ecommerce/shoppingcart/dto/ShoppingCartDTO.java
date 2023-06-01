package br.com.fatecmogidascruzes.ecommerce.shoppingcart.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;
import br.com.fatecmogidascruzes.ecommerce.shoppingcart.ShoppingCart;

public class ShoppingCartDTO {

	private List<ShoppingCartItem> items = new ArrayList<>();
	private Double total;

	public Double getTotal() {
		return total;
	}

	public List<ShoppingCartItem> getItems() {
		return items;
	}

	public static ShoppingCartDTO from(ShoppingCart shoppingCart) {
		ShoppingCartDTO dto = new ShoppingCartDTO();

		for (Product product : shoppingCart.getProducts()) {
			ShoppingCartItem item = new ShoppingCartItem();
			item.amount = shoppingCart.getAmountOf(product);
			item.cost = shoppingCart.getProductCost(product);
			item.perishable = product.getPerishable();
			item.productId = product.getId();
			item.productName = product.getName();
			item.productPrice = product.getPrice();
			item.productPhotoURL = product.getPhoto().getFileName();

			dto.items.add(item);
		}

		dto.total = shoppingCart.getTotalCost();
		return dto;
	}

	public static class ShoppingCartItem {

		private Long productId;
		private String productPhotoURL;
		private String productName;
		private Double productPrice;
		private Boolean perishable;
		private int amount;
		private Double cost;

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public String getProductPhotoURL() {
			return productPhotoURL;
		}

		public void setProductPhotoURL(String productPhotoURL) {
			this.productPhotoURL = productPhotoURL;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public Double getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(Double productPrice) {
			this.productPrice = productPrice;
		}

		public Boolean getPerishable() {
			return perishable;
		}

		public void setPerishable(Boolean perishable) {
			this.perishable = perishable;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

	}

}
