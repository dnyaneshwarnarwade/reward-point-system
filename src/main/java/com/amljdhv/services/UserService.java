package com.amljdhv.services;

import com.amljdhv.consumer.Consumer;
import com.amljdhv.signup.User;
import com.amljdhv.signup.UserConsumer;

public interface UserService {
	public User findUserByEmail(String email);
	public User createUser(User user);
	public Consumer createUser(Consumer user);
	public void createReferralUser(User referralUser, long referredUserId);
	//public UserConsumer addParentChildIds (UserConsumer uc);
	public User update(User user, Long userId);
	
}
