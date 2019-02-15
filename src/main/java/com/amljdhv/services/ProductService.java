package com.amljdhv.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amljdhv.product.Product;

public interface ProductService extends JpaRepository<Product, Long>{
	
	List<Product> findAllByUserId(Long user_id);
	
	void add(Product product);
}
