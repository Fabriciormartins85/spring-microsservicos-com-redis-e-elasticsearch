package br.com.example.cart.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@RedisHash(value = "cart")
public class Cart {

	public Cart() {
	}

	public Cart(Integer id) {
		this.id = id;
	}

	@Id
	private Integer id;
	private List<Item> itens;
}
