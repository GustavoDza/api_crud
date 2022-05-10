package br.com.api.crud.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer quantityStock;
	private Double unitPrice;
	private LocalDateTime dateCreation;
	private LocalDateTime dateLastUpdate;
	@ManyToOne
	private Supplier supplierId;
	
	
	public Product() {
		
	}
	
	public Product(String name, Integer quantityStock, Double unitPrice, LocalDateTime dateCreation,
			LocalDateTime dataLastUpdate, Supplier supplierId){
		this.name = name;
		this.quantityStock = quantityStock;
		this.unitPrice = unitPrice;
		this.dateCreation = dateCreation;
		this.dateLastUpdate = dataLastUpdate;
		this.supplierId = supplierId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateCreation, dateLastUpdate, id, name, quantityStock, supplierId, unitPrice);
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
		return Objects.equals(dateCreation, other.dateCreation) && Objects.equals(dateLastUpdate, other.dateLastUpdate)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(quantityStock, other.quantityStock) && Objects.equals(supplierId, other.supplierId)
				&& Objects.equals(unitPrice, other.unitPrice);
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

	public Integer getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(Integer quantityStock) {
		this.quantityStock = quantityStock;
	}
	
	public void setQuantityStockPatch(Integer quantityStock) {
		this.quantityStock += quantityStock;
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
}