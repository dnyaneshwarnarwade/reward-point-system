package com.amljdhv.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAllCategoryByUserId(Long id) {
		return categoryRepository.findAllCategoryByUserId(id);
	}

}
