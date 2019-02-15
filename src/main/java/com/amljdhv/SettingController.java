package com.amljdhv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
	
	
	@GetMapping(value = "setting")
	public ModelAndView setting(){
		ModelAndView view = new ModelAndView();
		view.setViewName("setting/setting");
		view.addObject("model","setting");
		return view;
	}

}
