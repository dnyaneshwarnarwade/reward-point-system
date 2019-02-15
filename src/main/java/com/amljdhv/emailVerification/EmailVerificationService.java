package com.amljdhv.emailVerification;

public interface EmailVerificationService {

	public EmailVerification insert(EmailVerification otp);
	public EmailVerification findByToken(String token);
}
