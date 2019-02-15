package com.amljdhv.home;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.amljdhv.services.UserService;

@Controller
class HomeController {

//    @ModelAttribute("module")
//	@GetMapping("")
 /*  public String module() {
    	System.out.println("CALLED THROW SIGN UP PAGE...THANK YOU - module - home");
        return "home";
    }*/

	@Autowired
	UserService userService;
	
   @GetMapping("/")
   public  String index(Principal principal, Model model) {
	   System.out.println("Here ( / ) i am");
	   model.addAttribute("module", "signIn");
	   model.addAttribute("signUp", "signUp");
       return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }
   
}
