package br.com.api.crud.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDateTime dateCreation;
	private LocalDateTime dateLastUpdate;
	
	@Override
	public int hashCode() {
		return Objects.hash(dateCreation, dateLastUpdate, id, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		return Objects.equals(dateCreation, other.dateCreation) && Objects.equals(dateLastUpdate, other.dateLastUpdate)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
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

}
