package com.amljdhv.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amljdhv.signup.Role;
import com.amljdhv.signup.User;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer  {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	
	
	//***************************POJO BEANS **************************
	@Bean
	public Role role(){
		return new Role();
	}
	
	@Bean
	public User user(){
		return new User();
	}
	

	
	
}
