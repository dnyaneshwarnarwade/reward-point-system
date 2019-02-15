package com.amljdhv.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.amljdhv.consumer.Consumer;
import com.amljdhv.consumer.ConsumerRepository;
import com.amljdhv.signup.Role;
import com.amljdhv.signup.User;
import com.amljdhv.signup.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ConsumerRepository consumerRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//@Autowired
	//private UserCustomerRepository userConsumerRepository;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User createUser(User user) {
		try{
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
		}catch(Exception ex){
			System.out.println("exception occured while saving user..!!!!!!!!!!!!!!!!!!!!!!!!");
			ex.printStackTrace();
			return null;
		}
	}

	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(userName);
		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getActive(), true, true, true, authorities);
	}

	@Override
	public void createReferralUser(User referralUser, long referredUserId) {
		// TODO Auto-generated method stub
		
	}


	/*@Override
	public UserConsumer addParentChildIds(UserConsumer uc) {
		return userConsumerRepository.save(uc);
		
	}*/

	@Override
	public User update(User user, Long userId) {
		User existingUser = userRepository.getOne(userId);
		existingUser.setPassword(user.getPassword());
		User updatedUser = userRepository.save(existingUser);
		return updatedUser;
	}

	@Override
	public Consumer createUser(Consumer user) {
		return consumerRepo.save(user);
	}

}