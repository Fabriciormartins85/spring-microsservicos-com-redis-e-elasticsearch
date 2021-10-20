package br.com.example.product.resource;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.product.dto.ProductDTO;
import br.com.example.product.exception.NotFoundException;
import br.com.example.product.model.Product;
import br.com.example.product.repository.ProductRepository;

@RestController(value = "product")
@RequestMapping(value = "product")
public class ProductResource {

	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO){
		Product produt = convertDtoToEntity(productDTO, Product.class);
		produt = repo.save(produt);
		return ResponseEntity.ok(convertEntityToDTO(produt, ProductDTO.class));	
	}
	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ProductDTO> byId(@PathVariable("id") Long id){
		Optional<Product> optionalProduct =  repo.findById(id);
		return ResponseEntity.ok(convertEntityToDTO(optionalProduct.orElseThrow(()-> new NotFoundException("Product Not Found")), ProductDTO.class));	
	}
	
	public <T> T convertDtoToEntity(Object classDTO, Class<T> classEntiy  ) {
		return mapper.map(classDTO, classEntiy);
	}
	public <T> T convertEntityToDTO(Object object,  Class<T> objectClass) {
		return mapper.map(object, objectClass);
	}

	
}
