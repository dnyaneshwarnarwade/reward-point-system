package com.amljdhv.shop;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amljdhv.services.UserService;
import com.amljdhv.signup.User;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private UserService userService;

	
	// just for redirect to the registration page
	@GetMapping("/registrationPage")
	public String registerPage(){
		return "shop/shopRegistration";
	}

	@GetMapping("/create")
	public String create(@Valid @ModelAttribute Shop shop, Principal principal){
		//@Valid @ModelAttribute Shop shop, Principal principal
		User user = userService.findUserByEmail(principal.getName());

		//create new persistent user
		User newUser = new User();
		newUser.setId(user.getId());

		// set the user
		shop.setUser(newUser);
		
		//finally save the shop
		shopRepository.save(shop);
		
		return "shop/shopRegistration";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute Shop shop, Principal principal){
		
		// update shop new account
		shopRepository.save(shop);
		
		// redirect to the shop registration page again 
		//Note : it should not redirect to the same page again but for temporary use keep as it is
		return "shop/shopRegistration";
	}
}