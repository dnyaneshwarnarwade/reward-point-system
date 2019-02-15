package com.amljdhv.consumer;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.amljdhv.services.ConsumerService;
import com.amljdhv.signup.User;
import com.amljdhv.util.UserView;

@RestController
public class ConsumerController{
	
	@Autowired
	private ConsumerService consumerService;
	
	@Autowired
	private UserView userView;
	
	@GetMapping("/getConsumer")
	public Consumer getConsumer(HttpSession session, @RequestParam("consumerId")Long consumerId) {
		return consumerService.getOne(consumerId);
	}
	
	@GetMapping("/consumers")
	public ModelAndView getAllConsumerList(HttpSession httpSession){
		ModelAndView view = new ModelAndView();
		List<Consumer> consumerList = consumerService.findAllByUserId(Long.valueOf(httpSession.getAttribute("loggedInUserId").toString()));
		view.addObject("consumers",consumerList);
		view.setViewName("/user/consumer-list");
		
		return view;
	}
	
	/*@GetMapping(value="/getAllConsumer")
//	@ResponseBody
	public List<Consumer> getAllConsumer(HttpSession session) {
		long loggerInUserId =@RequestBody (long) session.getAttribute("loggedInUserId");
		return consumerService.findAllByUserId(getUserId());
	}*/
	
	@PostMapping(value="/createConsumer",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public Boolean createConsumer( Consumer consumer, HttpSession session) {
		//User user = new User();
		//user.setId(userView.getUserId());
		
		consumer.setSearchString(String.join(",", Arrays.asList(
				consumer.getFirstName(),
				consumer.getLastName(),
				consumer.getEmail(),
				consumer.getPhone()
	             )));
		
		//consumer.setUser(user);
		System.out.println(consumer.toString());
		if(consumerService == null) {
			System.out.println("consumer servmive found nulll");
		}
		return consumerService.save(consumer) != null ? true : false;
	}
	
	@PostMapping(value="/consumer")
	public void deleteConsumer(@Valid @ModelAttribute Consumer consumer) {
		consumerService.delete(consumer);
	}
	
	@GetMapping(value="/searchCMR/{searchString}")
	public List<Consumer> searchConsumer(@PathVariable(value="searchString") final String searchString){
		System.out.println("Searching for::"+searchString);
		return consumerService.searchConsumer(searchString);
	}
}
