package br.com.api.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.crud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByName(String nameProduct);

}
