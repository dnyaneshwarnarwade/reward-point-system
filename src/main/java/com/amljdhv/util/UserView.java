package com.amljdhv.util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("userView")
public class UserView {


	@Autowired
	private  HttpSession httpSession;

	public  Long getUserId() {
		return Long.valueOf(httpSession.getAttribute("loggedInUserId").toString());
	}
	
	public  String getUserName () {
		return httpSession.getAttribute("username").toString();
	}
	
	public  String getAuthorities(){
		return httpSession.getAttribute("authorities").toString();
	}
}
