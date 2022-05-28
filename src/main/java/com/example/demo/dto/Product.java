package com.example.demo.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Product {

	@Id
	private String productId;
	private String name;
	private Integer unitPrice;
	private String description;
	private String manufacturer;
	private String category;
	private Integer unitsInStock;
	private String status;
	private String filename;
	private Integer quantity;

}
