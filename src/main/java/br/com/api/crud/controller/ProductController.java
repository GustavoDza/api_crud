package br.com.api.crud.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.crud.dto.ProductDto;
import br.com.api.crud.form.ProductForm;
import br.com.api.crud.model.Product;
import br.com.api.crud.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping
	public List<ProductDto> getProducts(String nameProduct){
		if(nameProduct == null) {
			List<Product> product = productRepository.findAll();
			return ProductDto.transform(product);
		}
		List<Product> product = productRepository.findByName(nameProduct);
		return ProductDto.transform(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getByIdProduts(@PathVariable Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return ResponseEntity.ok(new ProductDto(product.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProductDto> postProducts(@RequestBody @Valid ProductForm form, UriComponentsBuilder builder){
		Product product = form.insert();
		productRepository.save(product);
		URI uri = builder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDto(product));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> putProducts(@PathVariable Long id, @RequestBody ProductForm form){
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product product = form.update(id, productRepository);
			return ResponseEntity.ok(new ProductDto(product));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.ok("Exclusão feita com sucesso");
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> patchStockProduct(@PathVariable Long id, @RequestBody ProductForm form){
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product product = form.updateStock(id, productRepository);
			return ResponseEntity.ok(new ProductDto(product));
		}
		return ResponseEntity.notFound().build();
	}
	
}
