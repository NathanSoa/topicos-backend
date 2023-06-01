package br.com.fatecmogidascruzes.ecommerce.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecmogidascruzes.ecommerce.shoppingcart.dto.ShoppingCartAddProductDTO;
import br.com.fatecmogidascruzes.ecommerce.shoppingcart.dto.ShoppingCartDTO;
import br.com.fatecmogidascruzes.ecommerce.shoppingcart.dto.ShoppingCartUpdateProductDTO;

@RestController
@RequestMapping("/cart/items")
@CrossOrigin(origins = "http://localhost:8081",
allowCredentials = "true")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@GetMapping
	public ShoppingCartDTO get() {
		return ShoppingCartDTO.from(shoppingCartService.getShoppingCart());
	}
	
	@PostMapping
	public void addProduct(@RequestBody ShoppingCartAddProductDTO shoppingCartAddProductDTO) {
		shoppingCartService.addProduct(shoppingCartAddProductDTO.getProductId());
	}
	
	@PutMapping("/{id}")
	public void updateProduct(@PathVariable("id") Long productId, @RequestBody ShoppingCartUpdateProductDTO shoppingCartAddUpdateDTO) {
		shoppingCartService.updateProduct(productId, shoppingCartAddUpdateDTO.getAmount());
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Long productId) {
		shoppingCartService.removeProduct(productId);
	}

}
