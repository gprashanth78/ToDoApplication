package com.pharmacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_DTLS_TBL_OPM")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	@Column(name = "PRODUCT_NAME")
	private String name;
	@Column(name = "COMPANY_NAME")
	private String company;
	@Column(name = "PRODUCT_DOES")
	private String dose;
	@Column(name = "PRODUCT_STOCK")
	private String inStock;
	@Column(name = "PRODUCT_PRICE")
	private Double price;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", company=" + company + ", dose=" + dose
				+ ", inStock=" + inStock + ", price=" + price + "]";
	}

}
