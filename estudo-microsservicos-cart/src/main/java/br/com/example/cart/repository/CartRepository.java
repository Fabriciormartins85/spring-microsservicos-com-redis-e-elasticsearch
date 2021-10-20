package br.com.example.cart.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.example.cart.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {

}
