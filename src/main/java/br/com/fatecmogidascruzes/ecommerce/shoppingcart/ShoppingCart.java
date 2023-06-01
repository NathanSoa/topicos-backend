package br.com.fatecmogidascruzes.ecommerce.shoppingcart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;

@Component
@SessionScope
public class ShoppingCart {

	private Map<Product, Integer> items = new HashMap<>();
	
	public Double getTotalCost() {
		return items
				.keySet()
				.stream()
				.map(it -> getProductCost(it))
				.collect(Collectors.summingDouble(Double::doubleValue));
	}
	
	public Double getProductCost(Product product) {
		Integer currentAmount = items.get(product);
		if(currentAmount == null) {
			return 0d;
		}
		return currentAmount * product.getPrice();
	}
	
	public Collection<Product> getProducts() {
		return items.keySet();
	}
	
	public int getAmountOf(Product product) {
		Integer currentAmount = items.get(product);
		if(currentAmount == null) {
			return 0;
		}
		return currentAmount;
	}
	
	public void add(Product product) {
		Integer currentAmount = items.get(product);
		if(currentAmount == null) {
			currentAmount = 0;
		}
		items.put(product, currentAmount + 1);
	}
	
	public void update(Product product, int amount) {
		items.put(product, amount);
	}
	
	public void remove(Product product) {
		items.remove(product);
	}
	
	public void clear() {
		items.clear();
	}
	
}
