package br.com.example.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;

@Document(indexName = "product", createIndex = false)
@Getter
@Setter	
public class Product {

	@Id
	private Long id;
	private String name;
	private Integer amount;
}
