package com.amljdhv.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	List<Category> findAllCategoryByUserId(Long id);
	
	

}
