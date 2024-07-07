package com.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pharmacy.entity.Product;
import com.pharmacy.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/loadProductForm")
	public String loadProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "loadProductForm";
	}

	@PostMapping("/addProduct")
	public String addProductDetails(@ModelAttribute("product") Product product, RedirectAttributes attributes) {
		boolean saveProduct = productService.saveProduct(product);
		if (saveProduct) {
			if (product.getProductId() != null) {
				attributes.addFlashAttribute("updateMsg", "Updated the product details");
			} else {
				attributes.addFlashAttribute("succMsg", "saved product details");
			}
		} else {
			attributes.addFlashAttribute("errMsg", "Failed to add product");
		}

		return "redirect:/getAllProducts";
	}

	@GetMapping("/getAllProducts")
	public String getAllProduct(Model model) {
		List<Product> productsList = productService.getAllProducts();
		model.addAttribute("productsList", productsList);
		return "productList";
	}

	@GetMapping("/editProductDetails/{productId}")
	public String updateProductById(@PathVariable("productId") Integer productId, Model model) {
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "editProduct";
	}

	@GetMapping("/deleteProduct/{productId}")
	public String deleteToDoDetailsById(@PathVariable("productId") Integer productId, RedirectAttributes attribute) {
		boolean deleteProduct = productService.deleteProductById(productId);
		if (deleteProduct) {
			attribute.addFlashAttribute("succMsg", "Deleted product record successfully");
		} else {
			attribute.addFlashAttribute("errorMsg", "Unable to delete the record");
		}
		return "redirect:/getAllProducts";

	}
}
