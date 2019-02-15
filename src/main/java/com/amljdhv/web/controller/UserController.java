package com.amljdhv.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amljdhv.product.Product;
import com.amljdhv.services.ProductService;
import com.amljdhv.services.UserService;
import com.amljdhv.signup.User;
import com.amljdhv.util.UserView;

@RestController
public class UserController {
	
	@Autowired
	private  ProductService productService;
	
	@Autowired
	private  UserService userService;
	
	@Autowired
	private UserView userView;
	
	@GetMapping(value="/getAllProductsB.U.I",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getUserProduct(){
		return productService.findAllByUserId(userView.getUserId());
	}
	

	@PostMapping(value="changePassword.do")
	public Boolean changePassword(@ModelAttribute User form , HttpSession session) {
		long loggerInUserId = (long) session.getAttribute("loggedInUserId");
		if(userService.update(form , loggerInUserId) != null) {
			return true;
		}
		return false;
		
	}


}
