package com.amljdhv.signin;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

	@RequestMapping(value = "/signin")
	public String signin(Principal principal, Model model) {
		 model.addAttribute("module", "signUp");
		return principal != null ? "home/homeSignedIn" : "signin/signin";
    }
}
