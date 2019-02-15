package com.amljdhv.product;

import java.util.List;

public interface CategoryService {
	
	List<Category> findAllCategoryByUserId(Long id);

}
