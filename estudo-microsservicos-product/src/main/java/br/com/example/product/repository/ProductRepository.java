package br.com.example.product.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.example.product.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
