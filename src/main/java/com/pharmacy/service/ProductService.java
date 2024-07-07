package com.pharmacy.service;

import java.util.List;

import com.pharmacy.entity.Product;

public interface ProductService {

	public boolean saveProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductById(Integer productId);

	public boolean deleteProductById(Integer productId);
}
