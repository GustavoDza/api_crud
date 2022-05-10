package br.com.api.crud.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.api.crud.model.Product;
import br.com.api.crud.model.Supplier;

public class ProductDto {
	
	private Long id;
	private String name;
	private Integer quantityStock;
	private Double unitPrice;
	private LocalDateTime dateCreation;
	private LocalDateTime dateLastUpdate;
	private Supplier supplierId;
	
	
	public ProductDto(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.quantityStock = product.getQuantityStock();
		this.unitPrice = product.getUnitPrice();
		this.dateCreation = product.getDateCreation();
		this.dateLastUpdate = product.getDateLastUpdate();
		this.supplierId = product.getSupplierId();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getQuantityStock() {
		return quantityStock;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}
	
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public LocalDateTime getDateLastUpdate() {
		return dateLastUpdate;
	}

	public Supplier getSupplierId() {
		return supplierId;
	}

	public static List<ProductDto> transform(List<Product> product) {
		return product.stream().map(ProductDto::new).collect(Collectors.toList());
	}	

}
