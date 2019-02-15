package com.amljdhv.web.config.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.amljdhv.services.UserService;


@Component
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	
	@Autowired
	private UserService userService;
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication)
			throws IOException, ServletException {
		
		System.out.println("handilng session >>>>>>>>>>> JSFJSFSFSNFKSKFNSFSJEFNSNF");
		
		HttpSession session = request.getSession();
        org.springframework.security.core.userdetails.User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        com.amljdhv.signup.User applicationLocalUser = userService.findUserByEmail(authUser.getUsername());
        System.out.println(applicationLocalUser.toString());
        session.setAttribute("loggedInUserId", applicationLocalUser.getId());
        session.setAttribute("username", authUser.getUsername());
        session.setAttribute("authorities", authentication.getAuthorities());
 
        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);
 
        //since we have created our custom success handler, its up to us to where
        //we will redirect the user after successfully login
        response.sendRedirect("/"); //not working
	
	}
	
}
