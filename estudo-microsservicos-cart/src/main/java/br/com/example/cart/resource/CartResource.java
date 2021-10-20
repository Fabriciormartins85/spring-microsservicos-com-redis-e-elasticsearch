package br.com.example.cart.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.cart.dto.CartDTO;
import br.com.example.cart.dto.ItemDTO;
import br.com.example.cart.exception.NotFoundException;
import br.com.example.cart.model.Cart;
import br.com.example.cart.repository.CartRepository;

@RestController
@RequestMapping(value = "cart")
public class CartResource {

	@Autowired
	private CartRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("{cartId}")
	public ResponseEntity<CartDTO> addItemToCart(@PathVariable("cartId") Integer cartId,  @RequestBody ItemDTO item){
		var optionalCart = repo.findById(cartId);
		var cart = optionalCart.orElse(new Cart(cartId));
		var  dto = convertEntityToDTO(cart, CartDTO.class);
		dto.addItem(item);
		repo.save(convertDtoToEntity(dto, Cart.class));
		return ResponseEntity.ok(dto);
	}
	@GetMapping("{cartId}")
	public ResponseEntity<CartDTO> getCart(@PathVariable("cartId") Integer cartId){
		var optionalCart = repo.findById(cartId);
		var cartDto = convertEntityToDTO(optionalCart.orElseThrow(() -> new NotFoundException("Cart Not Found")), CartDTO.class);
		return ResponseEntity.ok(cartDto);
	}
	@DeleteMapping("{cartId}")
	public ResponseEntity<CartDTO> removeCart(@PathVariable("cartId") Integer cartId){
		  repo.deleteById(cartId);
		return ResponseEntity.noContent().build();
	}
	
	public <T> T convertDtoToEntity(Object classDTO, Class<T> classEntiy  ) {
		return mapper.map(classDTO, classEntiy);
	}
	public <T> T convertEntityToDTO(Object object,  Class<T> objectClass) {
		return mapper.map(object, objectClass);
	}

}
