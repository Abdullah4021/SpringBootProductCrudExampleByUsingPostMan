package com.javatechie.crud.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	// post method
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	// post method
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	// fetching list of product
	public List<Product> getProducts() {
		return repository.findAll();
	}

	// fetching single of product
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	// fetching single of product by name
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	//delete
	public  String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed"+id;
	}
	//update 
	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
}
