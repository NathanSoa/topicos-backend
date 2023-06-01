package br.com.fatecmogidascruzes.ecommerce.shoppingcart;

import br.com.fatecmogidascruzes.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecmogidascruzes.ecommerce.product.entities.Product;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCart shoppingCart;

	@Autowired
	private ProductRepository productRepository;
	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	
	public void addProduct(Long productId) {
		Product product = productRepository.findById(productId).orElseThrow(RuntimeException::new);
		shoppingCart.add(product);
	}
	
	public void updateProduct(Long productId, int newAmount) {
		Product product = productRepository.findById(productId).orElseThrow(RuntimeException::new);
		shoppingCart.update(product, newAmount);
	}
	
	public void removeProduct(Long productId) {
		Product product = productRepository.findById(productId).orElseThrow(RuntimeException::new);
		shoppingCart.remove(product);
	}
}
