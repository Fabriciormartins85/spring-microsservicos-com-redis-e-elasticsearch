package br.com.example.cart.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class CartDTO {
	@Getter
	@Setter
	private Integer id;
	@Setter
	private List<ItemDTO> itens;

	public List<ItemDTO> getItens() {
		itens = itens == null ? new ArrayList<>() : itens;
		return itens;
	}

	public void addItem(ItemDTO item) {
		if (getItens().stream().anyMatch(it -> item.getProductId().equals(it.getProductId()))) {
			getItens().stream().forEach(it -> {
				if (it.getProductId().equals(item.getProductId())) {
					it.setAmount(it.getAmount() + item.getAmount());
				}
			});
			return;
		}
		getItens().add(item);
	}
}
