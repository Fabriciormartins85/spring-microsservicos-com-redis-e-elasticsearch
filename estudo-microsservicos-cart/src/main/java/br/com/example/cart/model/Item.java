package br.com.example.cart.model;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash(value = "item")
public class Item {

	private Long productId;
	private Integer amount;
}
