package org.sp.app0828.domain;

import lombok.Data;

@Data
public class Product {
	private int product_idx;
	private SubCategory subcategory;
	private String product_name;
	private String brand;
	private int price;
	private String detail;
}
