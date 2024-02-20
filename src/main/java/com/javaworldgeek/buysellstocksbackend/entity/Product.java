package com.javaworldgeek.buysellstocksbackend.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document
public class Product {

	@Id
	private String id;
	private String name;
	private int quantity;
	private BigDecimal price;
	private TransactionType transType;
	private StockStatus stockSts;
	
	public Product(
			String name, 
			int quantity, 
			BigDecimal price, 
			TransactionType transType, 
			StockStatus stockSts) {
		
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.transType = transType;
		this.stockSts = stockSts;
		
	}
	
	
	
	
}
