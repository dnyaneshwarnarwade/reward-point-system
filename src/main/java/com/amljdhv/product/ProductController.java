package com.amljdhv.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amljdhv.services.ProductService;
import com.amljdhv.support.web.Message;
import com.amljdhv.support.web.Message.Type;


@RestController
public class ProductController {
	
	
	@Autowired
	private ProductService productServiceImpl;
	
	@PostMapping(value="/addProduct",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public Message addProduct(@RequestBody Product entity) {
		Message message = new Message("Product Saved Successfully", Type.SUCCESS);
		productServiceImpl.add(entity);
		return message;
	}

}
