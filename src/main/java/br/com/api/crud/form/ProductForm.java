package br.com.api.crud.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.api.crud.model.Product;
import br.com.api.crud.model.Supplier;
import br.com.api.crud.repository.ProductRepository;

public class ProductForm {
	
	@NotNull @NotEmpty
	private String name;
	
	@NotNull
	private Integer quantityStock;
	
	@NotNull
	private Double unitPrice;
	
	@NotNull 
	private LocalDateTime dateCreation;
	
	@NotNull
	private LocalDateTime dateLastUpdate;
	
	@NotNull
	private Supplier supplierId;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getQuantityStock() {
		return quantityStock;
	}
	
	public void setQuantityStock(Integer quantityStock) {
		this.quantityStock = quantityStock;
	}
	
	public Double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDateTime getDateLastUpdate() {
		return dateLastUpdate;
	}

	public void setDateLastUpdate(LocalDateTime dateLastUpdate) {
		this.dateLastUpdate = dateLastUpdate;
	}
	
	public Supplier getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Supplier supplierId) {
		this.supplierId = supplierId;
	}

	public Product insert(){
		return new Product(name, quantityStock, unitPrice, dateCreation, dateLastUpdate, getSupplierId());
	}
	
	public Product update(Long id, ProductRepository productRepository) {
		Product product = productRepository.getById(id);
		product.setName(this.name);
		product.setQuantityStock(this.quantityStock);
		product.setUnitPrice(this.unitPrice);
		product.setSupplierId(this.supplierId);
		product.setDateCreation(this.dateCreation);
		product.setDateLastUpdate(this.dateLastUpdate);
		return product;
	}
	
	public Product updateStock(Long id, ProductRepository productRepository) {
		Product product = productRepository.getById(id);
		product.setQuantityStockPatch(this.quantityStock);
		return product;
	}

}
