package com.amljdhv.emailVerification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmailVerificationServiceImple implements EmailVerificationService{

//	@PersistenceContext
//	private EntityManager em;
	
	@Autowired
	private EmailVerificationRepository otpRepository;

	@Override
	public EmailVerification insert(EmailVerification otp) {
		return otpRepository.save(otp);
	}

	@Override
	public EmailVerification findByToken(String token) {
		return otpRepository.findByToken(token);
	}
	
	
	

}
