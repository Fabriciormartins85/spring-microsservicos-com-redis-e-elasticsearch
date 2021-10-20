package br.com.example.product.dto;

import java.time.Instant;

import lombok.Getter;

public class ErrorMessage {

	@Getter
	private Integer code;
	private StringBuilder messageBuilder;
	@Getter
	private Instant date;
	
	public ErrorMessage(Integer code, Instant date, String message) {
		messageBuilder = messageBuilder == null ? new StringBuilder() : messageBuilder;
		messageBuilder.append(message);
		this.code = code;
		this.date = date;
	}
	
	public String getMessage() {
		return messageBuilder == null ? null : messageBuilder.toString();
	}
}
