package com.amljdhv.emailVerification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailVerificationController {
	
	@Autowired
	private EmailVerificationService otpService;

	
	//
	@GetMapping("/verify")
	public ModelAndView verifyEmailByLink(@RequestParam String token){
		
		EmailVerification isOTPExist = otpService.findByToken(token);
		
		ModelAndView view  = new ModelAndView();
		
		if(isOTPExist != null){
			// delete opt from table
			// better option for this functionality is to update the status
			// if isVerifies = true then move to the dashboard else (verify email page)
			
		}
		
		return null;
		
		
		
		
	}
}
