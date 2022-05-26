package com.example.demo.dto;

import lombok.Data;

@Data
public class Product {
	private String productId;
	private String pname;
	private Integer unitPrice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private String condition;
	private String filename;
	private int quantity;

	
	
}
