package com.amljdhv.signup;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.amljdhv.consumer.Consumer;
import com.amljdhv.emailVerification.EmailVerification;
import com.amljdhv.emailVerification.EmailVerificationService;
import com.amljdhv.emailVerification.VerificationType;
import com.amljdhv.services.UserService;
import com.amljdhv.support.web.Message;
import com.amljdhv.util.email.Email;
import com.amljdhv.util.email.EmailService;
import com.amljdhv.util.email.EmailTemplate;

//@Controller
@RestController
class SignupController {


	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	private String from = "dnyaneshwarnarwade91@gmail.com";
	private String to = "dnyaneshwarnarwade91@gmail.com";



	@Autowired
	private EmailVerificationService otpService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserService accountService;


	/**
	 * 
	 * <p> This call redirect the page accordingly user if the user is consumer or application user
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping({"/signUp", "consumerSignUpPage.do"})
	public ModelAndView signup(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();

		String path = request.getRequestURI().toString().replaceAll("/", "");

		System.out.println("Sign up controller......................:::"+path);

		User user = new User();

		modelAndView.addObject("user", user);
		modelAndView.addObject("module", "signIn");

		if(path.equals("consumerSignUpPage.do")){
			modelAndView.setViewName("signup/consumer-sign-up");
		}else if(path.equals("signUp")){
			modelAndView.setViewName("signup/signup");
		}

		return modelAndView;
	}

	@PostMapping(value="/consumerSignUp.do",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public Message registerConsumer (@Valid @ModelAttribute Consumer form,
			HttpSession session){

		Long vid = Long.valueOf(session.getAttribute("loggedInUserId").toString());
	
		System.out.println("loggd in user id ::"+vid);

		Message message = null;
		User user = new  User();
		user.setId(vid);
		Consumer consumer = new Consumer();
		consumer.setEmail(form.getEmail());
		consumer.setPhone(form.getPhone());
		Set<Consumer> set  = new HashSet<>();
		set.add(consumer);
		user.setVc(set);
		
		System.out.println("registering consumer................");

		User isUserExist = accountService.findUserByEmail(form.getEmail());
		if(isUserExist != null){
			User newUser = accountService.createUser(user);
			message = new Message("User Registered Successfully with "+newUser.getEmail(), Message.Type.SUCCESS);
		}else{
			message = new Message("User Failed to create account with "+form.getEmail(), Message.Type.DANGER);
		}

		return message;
	}

	@PostMapping(value="/signUp",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public Message createBusinessAccount(@RequestBody User userForm) {
		
		userForm.setAccountType(AccountType.BUSINESS.toString().toLowerCase());
		System.out.println("accountType::"+userForm.getAccountType());
		System.out.println("all::"+userForm.toString());

		if(userForm.getUsrps() != null) {
			userForm.setPassword(userForm.getUsrps());
		}

		User isUserExist = accountService.findUserByEmail(userForm.getEmail());
		
		Message message = null;
		if(isUserExist != null){
			message = new Message("User Already Exist with "+userForm.getEmail(), Message.Type.WARNING);
			//view.addObject("isEmailExist", "User email id already exist ! Please, try another email id.");
			return message;
		}
		
		final Set<Role> roles = new HashSet<>();
		final Role role = new Role();
		System.err.println("create use account as - business acc");
		userForm.setAccountType(AccountType.BUSINESS.toString().toLowerCase());
		role.setRole(Role.ROLE_ADMIN);

		synchronized (roles) {
			roles.add(role);
		}

		userForm.setActive(true);
		userForm.setRoles(roles);
		User isUserCreated = accountService.createUser(userForm);

		if(isUserCreated != null && !isUserCreated.getRoles().isEmpty()){
			System.out.println(isUserCreated.toString());
			//view.addObject("ACCOUNT_CREATED_SUCCESS_MSG", "Hi, "+ userForm.getName() + "! Your account has been created successfully !");
			message = new Message("User Registered Successfully with "+userForm.getEmail(), Message.Type.SUCCESS);
			/*boolean isOTPSent = sendEmailConfirmationOTP(isUserCreated);
			if(isOTPSent){
				System.out.println("OTP sent successfully");
				view.addObject("OTP_SUCCESS", "Email has been sent to your email, Please verify your account");
			}*/

		}else {
			message = new Message("Could not create account with "+userForm.getEmail(), Message.Type.DANGER);
		//	view.addObject("ACCOUNT_CREATED_SUCCESS_MSG", "Hi, "+ userForm.getName() + "! Your account creation failed due to some server connectivity problem please contact to the admin  : <a href='/contactUs'>Click here</a>");
		}

		//view.setViewName("signin/signin");

		return message;
	}

	public boolean sendEmailConfirmationOTP(User user){

		try{
			String token = user.getEmail();  

			EmailVerification ev = new EmailVerification ();
			ev.setEmail(user.getEmail());
			ev.setVerified(false);
			ev.setExpired(false);
			ev.setVerificationFailed(false);
			ev.setToken(bCryptPasswordEncoder.encode(String.valueOf(token)));
			ev.setUser(user);
			ev.setVerificationType(VerificationType.EMAIL_VERIFICATION.toString().toLowerCase());

			EmailVerification isOTPCreated = otpService.insert(ev);


			EmailTemplate template = new EmailTemplate("first-time-email-verification.html");

			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("user", user.getEmail());
			replacements.put("today", String.valueOf(new Date()));
			replacements.put("token", bCryptPasswordEncoder.encode(isOTPCreated.getToken()));
			replacements.put("team", "Reward Point Team");

			String message = template.getTemplate(replacements);

			Email email = new Email(from, to, "Please complete your OTP verification", message);
			email.setHtml(true);
			emailService.send(email);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}




}